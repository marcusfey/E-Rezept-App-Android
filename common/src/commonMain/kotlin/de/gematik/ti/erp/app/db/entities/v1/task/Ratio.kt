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

package de.gematik.ti.erp.app.db.entities.v1.task

import de.gematik.ti.erp.app.db.entities.Cascading
import io.realm.kotlin.Deleteable
import io.realm.kotlin.types.RealmObject

class RatioEntityV1 : RealmObject, Cascading {
    var numerator: QuantityEntityV1? = null
    var denominator: QuantityEntityV1? = null

    override fun objectsToFollow(): Iterator<Deleteable> =
        iterator {
            numerator?.let { yield(it) }
            denominator?.let { yield(it) }
        }
}
