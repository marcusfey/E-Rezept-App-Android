/*
 * Copyright (c) 2024 gematik GmbH
 * 
 * Licensed under the EUPL, Version 1.2 or – as soon they will be approved by
 * the European Commission - subsequent versions of the EUPL (the Licence);
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 * 
 *     https://joinup.ec.europa.eu/software/page/eupl
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 * 
 */

package de.gematik.ti.erp.app.cardwall.usecase

import android.content.Context
import android.nfc.NfcAdapter
import de.gematik.ti.erp.app.ErezeptApp.Companion.applicationModule
import de.gematik.ti.erp.app.idp.model.IdpData
import de.gematik.ti.erp.app.idp.repository.IdpRepository
import de.gematik.ti.erp.app.profiles.repository.ProfileIdentifier
import de.gematik.ti.erp.app.settings.repository.CardWallRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

open class CardWallUseCase(
    private val idpRepository: IdpRepository,
    private val cardWallRepository: CardWallRepository
) {
    private val deviceHasNFCFlow =
        MutableStateFlow(applicationModule.androidContext().deviceHasNFC() || cardWallRepository.hasFakeNFCEnabled)
    val deviceHasNfcStateFlow: Flow<Boolean> = deviceHasNFCFlow.asStateFlow()
    fun updateDeviceNFCCapability(value: Boolean) {
        cardWallRepository.hasFakeNFCEnabled = value
        deviceHasNFCFlow.value = value
    }
    fun checkNfcEnabled(): Boolean = applicationModule.androidContext().nfcEnabled()
    fun authenticationData(profileId: ProfileIdentifier): Flow<IdpData.AuthenticationData> =
        idpRepository.authenticationData(profileId)
}

fun Context.deviceHasNFC(): Boolean =
    this.packageManager.hasSystemFeature("android.hardware.nfc")

private fun Context.nfcEnabled(): Boolean = if (this.deviceHasNFC()) {
    NfcAdapter.getDefaultAdapter(this).isEnabled
} else {
    false
}
