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

package de.gematik.ti.erp.app.pharmacy.repository

import de.gematik.ti.erp.app.fhir.model.PharmacyServices
import de.gematik.ti.erp.app.fhir.model.extractPharmacyServices
import de.gematik.ti.erp.app.fhir.model.json
import de.gematik.ti.erp.app.pharmacy.model.OverviewPharmacyData
import de.gematik.ti.erp.app.pharmacy.usecase.model.PharmacyUseCaseData
import io.github.aakira.napier.Napier
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

@Suppress("LargeClass")
class PharmacyMockRepository : PharmacyRepository {

    override suspend fun searchPharmacies(names: List<String>, filter: Map<String, String>): Result<PharmacyServices> {
        return Result.success(extractedPharmacies)
    }

    override suspend fun searchPharmaciesByBundle(bundleId: String, offset: Int, count: Int): Result<PharmacyServices> {
        return Result.success(extractedPharmacies)
    }

    override suspend fun searchBinaryCerts(locationId: String): Result<List<String>> {
        return Result.success(emptyList())
    }

    override suspend fun redeemPrescriptionDirectly(
        url: String,
        message: ByteArray,
        pharmacyTelematikId: String,
        transactionId: String
    ): Result<Unit> {
        return Result.success(Unit)
    }

    override fun loadOftenUsedPharmacies(): Flow<List<OverviewPharmacyData.OverviewPharmacy>> {
        return flowOf(emptyList())
    }

    override fun loadFavoritePharmacies(): Flow<List<OverviewPharmacyData.OverviewPharmacy>> {
        return flowOf(emptyList())
    }

    @Suppress("EmptyFunctionBlock")
    override suspend fun saveOrUpdateOftenUsedPharmacy(pharmacy: PharmacyUseCaseData.Pharmacy) {
    }

    @Suppress("EmptyFunctionBlock")
    override suspend fun deleteOverviewPharmacy(overviewPharmacy: OverviewPharmacyData.OverviewPharmacy) {
    }

    @Suppress("EmptyFunctionBlock")
    override suspend fun saveOrUpdateFavoritePharmacy(pharmacy: PharmacyUseCaseData.Pharmacy) {
    }

    @Suppress("EmptyFunctionBlock")
    override suspend fun deleteFavoritePharmacy(favoritePharmacy: PharmacyUseCaseData.Pharmacy) {
    }

    override suspend fun searchPharmacyByTelematikId(telematikId: String): Result<PharmacyServices> {
        return Result.success(extractedPharmacies)
    }

    override fun isPharmacyInFavorites(pharmacy: PharmacyUseCaseData.Pharmacy): Flow<Boolean> {
        return flowOf(true)
    }

    @Suppress("EmptyFunctionBlock")
    override suspend fun markAsRedeemed(taskId: String) {
    }

    private val jsonStringMocked = """{
  "id": "49b6b9fd-eec7-41f3-b624-cc99d46fb828",
  "meta": {
    "lastUpdated": "2023-08-31T12:18:10.94674676+02:00"
  },
  "resourceType": "Bundle",
  "type": "searchset",
  "total": 20,
  "link": [
    {
      "relation": "self",
      "url": "Bundle49b6b9fd-eec7-41f3-b624-cc99d46fb828"
    }
  ],
  "entry": [
    {
      "resource": {
        "id": "6bb01538-5924-4be3-98ff-7475d27aee4f",
        "meta": {
          "lastUpdated": "2023-08-07T10:48:51.845+02:00",
          "versionId": "3"
        },
        "resourceType": "Location",
        "address": {
          "type": "physical",
          "line": [
            "ZoTIstr. 01"
          ],
          "postalCode": "10117",
          "city": "ZoTI-Town",
          "country": "D"
        },
        "hoursOfOperation": [
          {
            "daysOfWeek": [
              "mon",
              "tue",
              "wed",
              "thu",
              "fri"
            ],
            "openingTime": "08:00:00",
            "closingTime": "18:00:00"
          }
        ],
        "identifier": [
          {
            "system": "https://gematik.de/fhir/NamingSystem/TelematikID",
            "value": "3-01.2.2023001.16.201"
          }
        ],
        "name": "ZoTI_01_TEST-ONLY",
        "position": {
          "latitude": 13.387627883956709,
          "longitude": 52.5226398750957
        },
        "status": "active",
        "type": [
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/service-type",
                "code": "DELEGATOR",
                "display": "eRX Token Receiver"
              }
            ]
          }
        ]
      },
      "search": {
        "mode": "match"
      }
    },
    {
      "resource": {
        "id": "6bb02538-5924-4be3-98ff-7475d27aee4f",
        "meta": {
          "lastUpdated": "2023-08-07T10:48:51.845+02:00",
          "versionId": "3"
        },
        "resourceType": "Location",
        "address": {
          "type": "physical",
          "line": [
            "ZoTIstr. 02"
          ],
          "postalCode": "10117",
          "city": "ZoTI-Town",
          "country": "D"
        },
        "hoursOfOperation": [
          {
            "daysOfWeek": [
              "mon",
              "tue",
              "wed",
              "thu",
              "fri"
            ],
            "openingTime": "08:00:00",
            "closingTime": "18:00:00"
          }
        ],
        "identifier": [
          {
            "system": "https://gematik.de/fhir/NamingSystem/TelematikID",
            "value": "3-01.2.2023001.16.202"
          }
        ],
        "name": "ZoTI_02_TEST-ONLY",
        "position": {
          "latitude": 13.387627883956709,
          "longitude": 52.5226398750957
        },
        "status": "active",
        "telecom": [
          {
            "system": "other",
            "value": "https://erp-pharmacy-serviceprovider.dev.gematik.solutions/pick_up/<ti_id>",
            "use": "mobile",
            "rank": 100
          }
        ],
        "type": [
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/service-type",
                "code": "DELEGATOR",
                "display": "eRX Token Receiver"
              }
            ]
          }
        ]
      },
      "search": {
        "mode": "match"
      }
    },
    {
      "resource": {
        "id": "6bb03538-5924-4be3-98ff-7475d27aee4f",
        "meta": {
          "lastUpdated": "2023-08-07T10:48:51.845+02:00",
          "versionId": "3"
        },
        "resourceType": "Location",
        "address": {
          "type": "physical",
          "line": [
            "ZoTIstr. 03"
          ],
          "postalCode": "10117",
          "city": "ZoTI-Town",
          "country": "D"
        },
        "hoursOfOperation": [
          {
            "daysOfWeek": [
              "mon",
              "tue",
              "wed",
              "thu",
              "fri"
            ],
            "openingTime": "08:00:00",
            "closingTime": "18:00:00"
          }
        ],
        "identifier": [
          {
            "system": "https://gematik.de/fhir/NamingSystem/TelematikID",
            "value": "3-01.2.2023001.16.203"
          }
        ],
        "name": "ZoTI_03_TEST-ONLY",
        "position": {
          "latitude": 13.387627883956709,
          "longitude": 52.5226398750957
        },
        "status": "active",
        "telecom": [
          {
            "system": "other",
            "value": "https://erp-pharmacy-serviceprovider.dev.gematik.solutions/local_delivery/?req=<transactionID>",
            "use": "mobile",
            "rank": 200
          }
        ],
        "type": [
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/service-type",
                "code": "DELEGATOR",
                "display": "eRX Token Receiver"
              }
            ]
          }
        ]
      },
      "search": {
        "mode": "match"
      }
    },
    {
      "resource": {
        "id": "6bb04538-5924-4be3-98ff-7475d27aee4f",
        "meta": {
          "lastUpdated": "2023-08-07T10:48:51.845+02:00",
          "versionId": "3"
        },
        "resourceType": "Location",
        "address": {
          "type": "physical",
          "line": [
            "ZoTIstr. 04"
          ],
          "postalCode": "10117",
          "city": "ZoTI-Town",
          "country": "D"
        },
        "hoursOfOperation": [
          {
            "daysOfWeek": [
              "mon",
              "tue",
              "wed",
              "thu",
              "fri"
            ],
            "openingTime": "08:00:00",
            "closingTime": "18:00:00"
          }
        ],
        "identifier": [
          {
            "system": "https://gematik.de/fhir/NamingSystem/TelematikID",
            "value": "3-01.2.2023001.16.204"
          }
        ],
        "name": "ZoTI_04_TEST-ONLY",
        "position": {
          "latitude": 13.387627883956709,
          "longitude": 52.5226398750957
        },
        "status": "active",
        "telecom": [
          {
            "system": "other",
            "value": "https://erp-pharmacy-serviceprovider.dev.gematik.solutions/local_delivery/?req=<transactionID>",
            "use": "mobile",
            "rank": 300
          }
        ],
        "type": [
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/service-type",
                "code": "DELEGATOR",
                "display": "eRX Token Receiver"
              }
            ]
          }
        ]
      },
      "search": {
        "mode": "match"
      }
    },
    {
      "resource": {
        "id": "6bb05538-5924-4be3-98ff-7475d27aee4f",
        "meta": {
          "lastUpdated": "2023-08-07T10:48:51.845+02:00",
          "versionId": "3"
        },
        "resourceType": "Location",
        "address": {
          "type": "physical",
          "line": [
            "ZoTIstr. 05"
          ],
          "postalCode": "10117",
          "city": "ZoTI-Town",
          "country": "D"
        },
        "hoursOfOperation": [
          {
            "daysOfWeek": [
              "mon",
              "tue",
              "wed",
              "thu",
              "fri"
            ],
            "openingTime": "08:00:00",
            "closingTime": "18:00:00"
          }
        ],
        "identifier": [
          {
            "system": "https://gematik.de/fhir/NamingSystem/TelematikID",
            "value": "3-01.2.2023001.16.205"
          }
        ],
        "name": "ZoTI_05_TEST-ONLY",
        "position": {
          "latitude": 13.387627883956709,
          "longitude": 52.5226398750957
        },
        "status": "active",
        "type": [
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/service-type",
                "code": "DELEGATOR",
                "display": "eRX Token Receiver"
              }
            ]
          },
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
                "code": "OUTPHARM",
                "display": "outpatient pharmacy"
              }
            ]
          }
        ]
      },
      "search": {
        "mode": "match"
      }
    },
    {
      "resource": {
        "id": "6bb06538-5924-4be3-98ff-7475d27aee4f",
        "meta": {
          "lastUpdated": "2023-08-07T10:48:51.845+02:00",
          "versionId": "2"
        },
        "resourceType": "Location",
        "contained": [
          {
            "id": "2d1f1f35-d03d-4932-a78a-67715cbb7963",
            "resourceType": "HealthcareService",
            "active": true,
            "coverageArea": [
              {
                "extension": [
                  {
                    "url": "https://ngda.de/fhir/extensions/ServiceCoverageRange",
                    "valueQuantity": {
                      "value": 10000,
                      "unit": "m"
                    }
                  }
                ]
              }
            ],
            "location": [
              {
                "reference": "/Location/6bb06538-5924-4be3-98ff-7475d27aee4f"
              }
            ],
            "type": [
              {
                "coding": [
                  {
                    "system": "http://terminology.hl7.org/CodeSystem/service-type",
                    "code": "498",
                    "display": "Mobile Services"
                  }
                ]
              }
            ]
          }
        ],
        "address": {
          "type": "physical",
          "line": [
            "ZoTIstr. 06"
          ],
          "postalCode": "10117",
          "city": "ZoTI-Town",
          "country": "D"
        },
        "hoursOfOperation": [
          {
            "daysOfWeek": [
              "mon",
              "tue",
              "wed",
              "thu",
              "fri"
            ],
            "openingTime": "08:00:00",
            "closingTime": "18:00:00"
          }
        ],
        "identifier": [
          {
            "system": "https://gematik.de/fhir/NamingSystem/TelematikID",
            "value": "3-01.2.2023001.16.206"
          }
        ],
        "name": "ZoTI_06_TEST-ONLY",
        "position": {
          "latitude": 13.387627883956709,
          "longitude": 52.5226398750957
        },
        "status": "active",
        "type": [
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
                "code": "PHARM",
                "display": "pharmacy"
              }
            ]
          }
        ]
      },
      "search": {
        "mode": "match"
      }
    },
    {
      "resource": {
        "id": "6bb07538-5924-4be3-98ff-7475d27aee4f",
        "meta": {
          "lastUpdated": "2023-08-07T10:48:51.845+02:00",
          "versionId": "3"
        },
        "resourceType": "Location",
        "address": {
          "type": "physical",
          "line": [
            "ZoTIstr. 07"
          ],
          "postalCode": "10117",
          "city": "ZoTI-Town",
          "country": "D"
        },
        "hoursOfOperation": [
          {
            "daysOfWeek": [
              "mon",
              "tue",
              "wed",
              "thu",
              "fri"
            ],
            "openingTime": "08:00:00",
            "closingTime": "18:00:00"
          }
        ],
        "identifier": [
          {
            "system": "https://gematik.de/fhir/NamingSystem/TelematikID",
            "value": "3-01.2.2023001.16.207"
          }
        ],
        "name": "ZoTI_07_TEST-ONLY",
        "position": {
          "latitude": 13.387627883956709,
          "longitude": 52.5226398750957
        },
        "status": "active",
        "type": [
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/service-type",
                "code": "DELEGATOR",
                "display": "eRX Token Receiver"
              }
            ]
          },
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
                "code": "MOBL",
                "display": "Mobile Services"
              }
            ]
          }
        ]
      },
      "search": {
        "mode": "match"
      }
    },
    {
      "resource": {
        "id": "6bb08538-5924-4be3-98ff-7475d27aee4f",
        "meta": {
          "lastUpdated": "2023-08-07T10:48:51.845+02:00",
          "versionId": "3"
        },
        "resourceType": "Location",
        "address": {
          "type": "physical",
          "line": [
            "ZoTIstr. 08"
          ],
          "postalCode": "10117",
          "city": "ZoTI-Town",
          "country": "D"
        },
        "hoursOfOperation": [
          {
            "daysOfWeek": [
              "mon",
              "tue",
              "wed",
              "thu",
              "fri"
            ],
            "openingTime": "08:00:00",
            "closingTime": "18:00:00"
          }
        ],
        "identifier": [
          {
            "system": "https://gematik.de/fhir/NamingSystem/TelematikID",
            "value": "3-01.2.2023001.16.208"
          }
        ],
        "name": "ZoTI_08_TEST-ONLY",
        "position": {
          "latitude": 13.387627883956709,
          "longitude": 52.5226398750957
        },
        "status": "active",
        "telecom": [
          {
            "system": "other",
            "value": "https://erp-pharmacy-serviceprovider.dev.gematik.solutions/delivery_only",
            "use": "mobile",
            "rank": 300
          },
          {
            "system": "other",
            "value": "https://erp-pharmacy-serviceprovider.dev.gematik.solutions/local_delivery/?req=<transactionID>",
            "use": "mobile",
            "rank": 200
          },
          {
            "system": "other",
            "value": "https://erp-pharmacy-serviceprovider.dev.gematik.solutions/pick_up/<ti_id>",
            "use": "mobile",
            "rank": 100
          }
        ],
        "type": [
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/service-type",
                "code": "DELEGATOR",
                "display": "eRX Token Receiver"
              }
            ]
          }
        ]
      },
      "search": {
        "mode": "match"
      }
    },
    {
      "resource": {
        "id": "6bb09538-5924-4be3-98ff-7475d27aee4f",
        "meta": {
          "lastUpdated": "2023-08-07T10:48:51.845+02:00",
          "versionId": "3"
        },
        "resourceType": "Location",
        "address": {
          "type": "physical",
          "line": [
            "ZoTIstr. 09"
          ],
          "postalCode": "10117",
          "city": "ZoTI-Town",
          "country": "D"
        },
        "hoursOfOperation": [
          {
            "daysOfWeek": [
              "mon",
              "tue",
              "wed",
              "thu",
              "fri"
            ],
            "openingTime": "08:00:00",
            "closingTime": "18:00:00"
          }
        ],
        "identifier": [
          {
            "system": "https://gematik.de/fhir/NamingSystem/TelematikID",
            "value": "3-01.2.2023001.16.209"
          }
        ],
        "name": "ZoTI_09_TEST-ONLY",
        "position": {
          "latitude": 13.387627883956709,
          "longitude": 52.5226398750957
        },
        "status": "active",
        "telecom": [
          {
            "system": "other",
            "value": "https://erp-pharmacy-serviceprovider.dev.gematik.solutions/delivery_only",
            "use": "mobile",
            "rank": 300
          },
          {
            "system": "other",
            "value": "https://erp-pharmacy-serviceprovider.dev.gematik.solutions/local_delivery/?req=<transactionid>",
            "use": "mobile",
            "rank": 200
          },
          {
            "system": "other",
            "value": "https://erp-pharmacy-serviceprovider.dev.gematik.solutions/pick_up/<ti_id>",
            "use": "mobile",
            "rank": 100
          }
        ],
        "type": [
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/service-type",
                "code": "DELEGATOR",
                "display": "eRX Token Receiver"
              }
            ]
          },
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
                "code": "OUTPHARM",
                "display": "outpatient pharmacy"
              }
            ]
          }
        ]
      },
      "search": {
        "mode": "match"
      }
    },
    {
      "resource": {
        "id": "6bb10538-5924-4be3-98ff-7475d27aee4f",
        "meta": {
          "lastUpdated": "2023-08-07T10:48:51.845+02:00",
          "versionId": "2"
        },
        "resourceType": "Location",
        "contained": [
          {
            "id": "fe9a01e8-d702-4b9d-a997-096eca057b74",
            "resourceType": "HealthcareService",
            "active": true,
            "coverageArea": [
              {
                "extension": [
                  {
                    "url": "https://ngda.de/fhir/extensions/ServiceCoverageRange",
                    "valueQuantity": {
                      "value": 10000,
                      "unit": "m"
                    }
                  }
                ]
              }
            ],
            "location": [
              {
                "reference": "/Location/6bb10538-5924-4be3-98ff-7475d27aee4f"
              }
            ],
            "type": [
              {
                "coding": [
                  {
                    "system": "http://terminology.hl7.org/CodeSystem/service-type",
                    "code": "498",
                    "display": "Mobile Services"
                  }
                ]
              }
            ]
          }
        ],
        "address": {
          "type": "physical",
          "line": [
            "ZoTIstr. 10"
          ],
          "postalCode": "10117",
          "city": "ZoTI-Town",
          "country": "D"
        },
        "hoursOfOperation": [
          {
            "daysOfWeek": [
              "mon",
              "tue",
              "wed",
              "thu",
              "fri"
            ],
            "openingTime": "08:00:00",
            "closingTime": "18:00:00"
          }
        ],
        "identifier": [
          {
            "system": "https://gematik.de/fhir/NamingSystem/TelematikID",
            "value": "3-01.2.2023001.16.210"
          }
        ],
        "name": "ZoTI_10_TEST-ONLY",
        "position": {
          "latitude": 13.387627883956709,
          "longitude": 52.5226398750957
        },
        "status": "active",
        "telecom": [
          {
            "system": "other",
            "value": "https://erp-pharmacy-serviceprovider.dev.gematik.solutions/delivery_only",
            "use": "mobile",
            "rank": 300
          },
          {
            "system": "other",
            "value": "https://erp-pharmacy-serviceprovider.dev.gematik.solutions/local_delivery/?req=<transactionid>",
            "use": "mobile",
            "rank": 200
          },
          {
            "system": "other",
            "value": "https://erp-pharmacy-serviceprovider.dev.gematik.solutions/pick_up/<ti_id>",
            "use": "mobile",
            "rank": 100
          }
        ],
        "type": [
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/service-type",
                "code": "DELEGATOR",
                "display": "eRX Token Receiver"
              }
            ]
          },
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
                "code": "PHARM",
                "display": "pharmacy"
              }
            ]
          },
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
                "code": "MOBL",
                "display": "Mobile Services"
              }
            ]
          }
        ]
      },
      "search": {
        "mode": "match"
      }
    },
    {
      "resource": {
        "id": "6bb11538-5924-4be3-98ff-7475d27aee4f",
        "meta": {
          "lastUpdated": "2023-08-07T10:48:51.845+02:00",
          "versionId": "2"
        },
        "resourceType": "Location",
        "contained": [
          {
            "id": "0991992b-b3fd-4f3e-a331-d4f0e2856185",
            "resourceType": "HealthcareService",
            "active": true,
            "coverageArea": [
              {
                "extension": [
                  {
                    "url": "https://ngda.de/fhir/extensions/ServiceCoverageRange",
                    "valueQuantity": {
                      "value": 10000,
                      "unit": "m"
                    }
                  }
                ]
              }
            ],
            "location": [
              {
                "reference": "/Location/6bb11538-5924-4be3-98ff-7475d27aee4f"
              }
            ],
            "type": [
              {
                "coding": [
                  {
                    "system": "http://terminology.hl7.org/CodeSystem/service-type",
                    "code": "498",
                    "display": "Mobile Services"
                  }
                ]
              }
            ]
          }
        ],
        "address": {
          "type": "physical",
          "line": [
            "ZoTIstr. 11"
          ],
          "postalCode": "10117",
          "city": "ZoTI-Town",
          "country": "D"
        },
        "hoursOfOperation": [
          {
            "daysOfWeek": [
              "mon",
              "tue",
              "wed",
              "thu",
              "fri"
            ],
            "openingTime": "08:00:00",
            "closingTime": "18:00:00"
          }
        ],
        "identifier": [
          {
            "system": "https://gematik.de/fhir/NamingSystem/TelematikID",
            "value": "3-01.2.2023001.16.211"
          }
        ],
        "name": "ZoTI_11_TEST-ONLY",
        "position": {
          "latitude": 13.387627883956709,
          "longitude": 52.5226398750957
        },
        "status": "active",
        "telecom": [
          {
            "system": "other",
            "value": "https://erp-pharmacy-serviceprovider.dev.gematik.solutions/delivery_only",
            "use": "mobile",
            "rank": 300
          },
          {
            "system": "other",
            "value": "https://erp-pharmacy-serviceprovider.dev.gematik.solutions/local_delivery/?req=<transactionid>",
            "use": "mobile",
            "rank": 200
          },
          {
            "system": "other",
            "value": "https://erp-pharmacy-serviceprovider.dev.gematik.solutions/pick_up/<ti_id>",
            "use": "mobile",
            "rank": 100
          }
        ],
        "type": [
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/service-type",
                "code": "DELEGATOR",
                "display": "eRX Token Receiver"
              }
            ]
          },
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
                "code": "PHARM",
                "display": "pharmacy"
              }
            ]
          },
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
                "code": "OUTPHARM",
                "display": "outpatient pharmacy"
              }
            ]
          },
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
                "code": "MOBL",
                "display": "Mobile Services"
              }
            ]
          }
        ]
      },
      "search": {
        "mode": "match"
      }
    },
    {
      "resource": {
        "id": "6bb12538-5924-4be3-98ff-7475d27aee4f",
        "meta": {
          "lastUpdated": "2023-08-07T10:48:51.845+02:00",
          "versionId": "2"
        },
        "resourceType": "Location",
        "contained": [
          {
            "id": "ae48f60e-9c17-4610-a0c4-d1f7ac6abb5b",
            "resourceType": "HealthcareService",
            "active": true,
            "coverageArea": [
              {
                "extension": [
                  {
                    "url": "https://ngda.de/fhir/extensions/ServiceCoverageRange",
                    "valueQuantity": {
                      "value": 10000,
                      "unit": "m"
                    }
                  }
                ]
              }
            ],
            "location": [
              {
                "reference": "/Location/6bb12538-5924-4be3-98ff-7475d27aee4f"
              }
            ],
            "type": [
              {
                "coding": [
                  {
                    "system": "http://terminology.hl7.org/CodeSystem/service-type",
                    "code": "498",
                    "display": "Mobile Services"
                  }
                ]
              }
            ]
          }
        ],
        "address": {
          "type": "physical",
          "line": [
            "ZoTIstr. 12"
          ],
          "postalCode": "10117",
          "city": "ZoTI-Town",
          "country": "D"
        },
        "hoursOfOperation": [
          {
            "daysOfWeek": [
              "mon",
              "tue",
              "wed",
              "thu",
              "fri"
            ],
            "openingTime": "08:00:00",
            "closingTime": "18:00:00"
          }
        ],
        "identifier": [
          {
            "system": "https://gematik.de/fhir/NamingSystem/TelematikID",
            "value": "3-01.2.2023001.16.212"
          }
        ],
        "name": "ZoTI_12_TEST-ONLY",
        "position": {
          "latitude": 13.387627883956709,
          "longitude": 52.5226398750957
        },
        "status": "active",
        "type": [
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/service-type",
                "code": "DELEGATOR",
                "display": "eRX Token Receiver"
              }
            ]
          },
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
                "code": "PHARM",
                "display": "pharmacy"
              }
            ]
          },
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
                "code": "OUTPHARM",
                "display": "outpatient pharmacy"
              }
            ]
          },
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
                "code": "MOBL",
                "display": "Mobile Services"
              }
            ]
          }
        ]
      },
      "search": {
        "mode": "match"
      }
    },
    {
      "resource": {
        "id": "6bb13538-5924-4be3-98ff-7475d27aee4f",
        "meta": {
          "lastUpdated": "2023-08-07T10:48:51.845+02:00",
          "versionId": "2"
        },
        "resourceType": "Location",
        "contained": [
          {
            "id": "e63f85da-3c1a-4f16-8059-45321bec107f",
            "resourceType": "HealthcareService",
            "active": true,
            "coverageArea": [
              {
                "extension": [
                  {
                    "url": "https://ngda.de/fhir/extensions/ServiceCoverageRange",
                    "valueQuantity": {
                      "value": 10000,
                      "unit": "m"
                    }
                  }
                ]
              }
            ],
            "location": [
              {
                "reference": "/Location/6bb13538-5924-4be3-98ff-7475d27aee4f"
              }
            ],
            "type": [
              {
                "coding": [
                  {
                    "system": "http://terminology.hl7.org/CodeSystem/service-type",
                    "code": "498",
                    "display": "Mobile Services"
                  }
                ]
              }
            ]
          }
        ],
        "address": {
          "type": "physical",
          "line": [
            "ZoTIstr. 13"
          ],
          "postalCode": "10117",
          "city": "ZoTI-Town",
          "country": "D"
        },
        "hoursOfOperation": [
          {
            "daysOfWeek": [
              "mon",
              "tue",
              "wed",
              "thu",
              "fri"
            ],
            "openingTime": "08:00:00",
            "closingTime": "18:00:00"
          }
        ],
        "identifier": [
          {
            "system": "https://gematik.de/fhir/NamingSystem/TelematikID",
            "value": "3-01.2.2023001.16.213"
          }
        ],
        "name": "ZoTI_13_TEST-ONLY",
        "position": {
          "latitude": 13.387627883956709,
          "longitude": 52.5226398750957
        },
        "status": "active",
        "telecom": [
          {
            "system": "other",
            "value": "https://erp-pharmacy-serviceprovider.dev.gematik.solutions/local_delivery/?req=<transactionid>",
            "use": "mobile",
            "rank": 200
          },
          {
            "system": "other",
            "value": "https://erp-pharmacy-serviceprovider.dev.gematik.solutions/pick_up/<ti_id>",
            "use": "mobile",
            "rank": 100
          }
        ],
        "type": [
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/service-type",
                "code": "DELEGATOR",
                "display": "eRX Token Receiver"
              }
            ]
          },
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
                "code": "PHARM",
                "display": "pharmacy"
              }
            ]
          },
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
                "code": "OUTPHARM",
                "display": "outpatient pharmacy"
              }
            ]
          },
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
                "code": "MOBL",
                "display": "Mobile Services"
              }
            ]
          }
        ]
      },
      "search": {
        "mode": "match"
      }
    },
    {
      "resource": {
        "id": "6bb14538-5924-4be3-98ff-7475d27aee4f",
        "meta": {
          "lastUpdated": "2023-08-07T10:48:51.845+02:00",
          "versionId": "2"
        },
        "resourceType": "Location",
        "contained": [
          {
            "id": "bb022669-f8fc-424a-8bfa-e9b5e8102333",
            "resourceType": "HealthcareService",
            "active": true,
            "coverageArea": [
              {
                "extension": [
                  {
                    "url": "https://ngda.de/fhir/extensions/ServiceCoverageRange",
                    "valueQuantity": {
                      "value": 10000,
                      "unit": "m"
                    }
                  }
                ]
              }
            ],
            "location": [
              {
                "reference": "/Location/6bb14538-5924-4be3-98ff-7475d27aee4f"
              }
            ],
            "type": [
              {
                "coding": [
                  {
                    "system": "http://terminology.hl7.org/CodeSystem/service-type",
                    "code": "498",
                    "display": "Mobile Services"
                  }
                ]
              }
            ]
          }
        ],
        "address": {
          "type": "physical",
          "line": [
            "ZoTIstr. 14"
          ],
          "postalCode": "10117",
          "city": "ZoTI-Town",
          "country": "D"
        },
        "hoursOfOperation": [
          {
            "daysOfWeek": [
              "mon",
              "tue",
              "wed",
              "thu",
              "fri"
            ],
            "openingTime": "08:00:00",
            "closingTime": "18:00:00"
          }
        ],
        "identifier": [
          {
            "system": "https://gematik.de/fhir/NamingSystem/TelematikID",
            "value": "3-01.2.2023001.16.214"
          }
        ],
        "name": "ZoTI_14_TEST-ONLY",
        "position": {
          "latitude": 13.387627883956709,
          "longitude": 52.5226398750957
        },
        "status": "active",
        "telecom": [
          {
            "system": "other",
            "value": "https://erp-pharmacy-serviceprovider.dev.gematik.solutions/delivery_only",
            "use": "mobile",
            "rank": 300
          },
          {
            "system": "other",
            "value": "https://erp-pharmacy-serviceprovider.dev.gematik.solutions/pick_up/<ti_id>",
            "use": "mobile",
            "rank": 100
          }
        ],
        "type": [
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/service-type",
                "code": "DELEGATOR",
                "display": "eRX Token Receiver"
              }
            ]
          },
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
                "code": "PHARM",
                "display": "pharmacy"
              }
            ]
          },
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
                "code": "OUTPHARM",
                "display": "outpatient pharmacy"
              }
            ]
          },
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
                "code": "MOBL",
                "display": "Mobile Services"
              }
            ]
          }
        ]
      },
      "search": {
        "mode": "match"
      }
    },
    {
      "resource": {
        "id": "6bb15538-5924-4be3-98ff-7475d27aee4f",
        "meta": {
          "lastUpdated": "2023-08-07T10:48:51.845+02:00",
          "versionId": "3"
        },
        "resourceType": "Location",
        "address": {
          "type": "physical",
          "line": [
            "ZoTIstr. 15"
          ],
          "postalCode": "10117",
          "city": "ZoTI-Town",
          "country": "D"
        },
        "hoursOfOperation": [
          {
            "daysOfWeek": [
              "mon",
              "tue",
              "wed",
              "thu",
              "fri"
            ],
            "openingTime": "08:00:00",
            "closingTime": "18:00:00"
          }
        ],
        "identifier": [
          {
            "system": "https://gematik.de/fhir/NamingSystem/TelematikID",
            "value": "3-01.2.2023001.16.215"
          }
        ],
        "name": "ZoTI_15_TEST-ONLY",
        "position": {
          "latitude": 13.387627883956709,
          "longitude": 52.5226398750957
        },
        "status": "active",
        "telecom": [
          {
            "system": "other",
            "value": "https://erp-pharmacy-serviceprovider.dev.gematik.solutions/delivery_only",
            "use": "mobile",
            "rank": 300
          },
          {
            "system": "other",
            "value": "https://erp-pharmacy-serviceprovider.dev.gematik.solutions/pick_up/<ti_id>",
            "use": "mobile",
            "rank": 100
          }
        ],
        "type": [
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/service-type",
                "code": "DELEGATOR",
                "display": "eRX Token Receiver"
              }
            ]
          }
        ]
      },
      "search": {
        "mode": "match"
      }
    },
    {
      "resource": {
        "id": "6bb16538-5924-4be3-98ff-7475d27aee4f",
        "meta": {
          "lastUpdated": "2023-08-07T10:48:51.845+02:00",
          "versionId": "3"
        },
        "resourceType": "Location",
        "address": {
          "type": "physical",
          "line": [
            "ZoTIstr. 16"
          ],
          "postalCode": "10117",
          "city": "ZoTI-Town",
          "country": "D"
        },
        "hoursOfOperation": [
          {
            "daysOfWeek": [
              "mon",
              "tue",
              "wed",
              "thu",
              "fri"
            ],
            "openingTime": "08:00:00",
            "closingTime": "18:00:00"
          }
        ],
        "identifier": [
          {
            "system": "https://gematik.de/fhir/NamingSystem/TelematikID",
            "value": "3-01.2.2023001.16.216"
          }
        ],
        "name": "ZoTI_16_TEST-ONLY",
        "position": {
          "latitude": 13.387627883956709,
          "longitude": 52.5226398750957
        },
        "status": "active",
        "telecom": [
          {
            "system": "other",
            "value": "https://erp-pharmacy-serviceprovider.dev.gematik.solutions/delivery_only",
            "use": "mobile",
            "rank": 300
          }
        ],
        "type": [
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/service-type",
                "code": "DELEGATOR",
                "display": "eRX Token Receiver"
              }
            ]
          },
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
                "code": "MOBL",
                "display": "Mobile Services"
              }
            ]
          }
        ]
      },
      "search": {
        "mode": "match"
      }
    },
    {
      "resource": {
        "id": "6bb17538-5924-4be3-98ff-7475d27aee4f",
        "meta": {
          "lastUpdated": "2023-08-07T10:48:51.845+02:00",
          "versionId": "2"
        },
        "resourceType": "Location",
        "contained": [
          {
            "id": "0f4ae22e-f717-47b1-893e-1d41684c8579",
            "resourceType": "HealthcareService",
            "active": true,
            "coverageArea": [
              {
                "extension": [
                  {
                    "url": "https://ngda.de/fhir/extensions/ServiceCoverageRange",
                    "valueQuantity": {
                      "value": 10000,
                      "unit": "m"
                    }
                  }
                ]
              }
            ],
            "location": [
              {
                "reference": "/Location/6bb17538-5924-4be3-98ff-7475d27aee4f"
              }
            ],
            "type": [
              {
                "coding": [
                  {
                    "system": "http://terminology.hl7.org/CodeSystem/service-type",
                    "code": "498",
                    "display": "Mobile Services"
                  }
                ]
              }
            ]
          }
        ],
        "address": {
          "type": "physical",
          "line": [
            "ZoTIstr. 17"
          ],
          "postalCode": "10117",
          "city": "ZoTI-Town",
          "country": "D"
        },
        "hoursOfOperation": [
          {
            "daysOfWeek": [
              "mon",
              "tue",
              "wed",
              "thu",
              "fri"
            ],
            "openingTime": "08:00:00",
            "closingTime": "18:00:00"
          }
        ],
        "identifier": [
          {
            "system": "https://gematik.de/fhir/NamingSystem/TelematikID",
            "value": "3-01.2.2023001.16.217"
          }
        ],
        "name": "ZoTI_17_TEST-ONLY",
        "position": {
          "latitude": 13.387627883956709,
          "longitude": 52.5226398750957
        },
        "status": "active",
        "telecom": [
          {
            "system": "other",
            "value": "https://erp-pharmacy-serviceprovider.dev.gematik.solutions/local_delivery/?req=<transactionid>",
            "use": "mobile",
            "rank": 200
          },
          {
            "system": "other",
            "value": "https://erp-pharmacy-serviceprovider.dev.gematik.solutions/pick_up/<ti_id>",
            "use": "mobile",
            "rank": 100
          }
        ],
        "type": [
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/service-type",
                "code": "DELEGATOR",
                "display": "eRX Token Receiver"
              }
            ]
          },
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
                "code": "PHARM",
                "display": "pharmacy"
              }
            ]
          }
        ]
      },
      "search": {
        "mode": "match"
      }
    },
    {
      "resource": {
        "id": "6bb18538-5924-4be3-98ff-7475d27aee4f",
        "meta": {
          "lastUpdated": "2023-08-07T10:48:51.845+02:00",
          "versionId": "3"
        },
        "resourceType": "Location",
        "address": {
          "type": "physical",
          "line": [
            "ZoTIstr. 18"
          ],
          "postalCode": "10117",
          "city": "ZoTI-Town",
          "country": "D"
        },
        "hoursOfOperation": [
          {
            "daysOfWeek": [
              "mon",
              "tue",
              "wed",
              "thu",
              "fri"
            ],
            "openingTime": "08:00:00",
            "closingTime": "18:00:00"
          }
        ],
        "identifier": [
          {
            "system": "https://gematik.de/fhir/NamingSystem/TelematikID",
            "value": "3-01.2.2023001.16.218"
          }
        ],
        "name": "ZoTI_18_TEST-ONLY",
        "position": {
          "latitude": 13.387627883956709,
          "longitude": 52.5226398750957
        },
        "status": "active",
        "telecom": [
          {
            "system": "other",
            "value": "https://erp-pharmacy-serviceprovider.dev.gematik.solutions/delivery_only",
            "use": "mobile",
            "rank": 300
          },
          {
            "system": "other",
            "value": "https://erp-pharmacy-serviceprovider.dev.gematik.solutions/local_delivery/?req=<transactionid>",
            "use": "mobile",
            "rank": 200
          },
          {
            "system": "other",
            "value": "https://erp-pharmacy-serviceprovider.dev.gematik.solutions/pick_up/<ti_id>",
            "use": "mobile",
            "rank": 100
          }
        ],
        "type": [
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/service-type",
                "code": "DELEGATOR",
                "display": "eRX Token Receiver"
              }
            ]
          },
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
                "code": "OUTPHARM",
                "display": "outpatient pharmacy"
              }
            ]
          },
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
                "code": "MOBL",
                "display": "Mobile Services"
              }
            ]
          }
        ]
      },
      "search": {
        "mode": "match"
      }
    },
    {
      "resource": {
        "id": "6bb19538-5924-4be3-98ff-7475d27aee4f",
        "meta": {
          "lastUpdated": "2023-08-07T10:48:51.845+02:00",
          "versionId": "2"
        },
        "resourceType": "Location",
        "contained": [
          {
            "id": "72ab1d02-d3e2-4af1-891f-a476c23eaf44",
            "resourceType": "HealthcareService",
            "active": true,
            "coverageArea": [
              {
                "extension": [
                  {
                    "url": "https://ngda.de/fhir/extensions/ServiceCoverageRange",
                    "valueQuantity": {
                      "value": 10000,
                      "unit": "m"
                    }
                  }
                ]
              }
            ],
            "location": [
              {
                "reference": "/Location/6bb1 2023-08-31 12:18:11.626 28938-31101 OkHttp                  de.gematik.ti.erp.app.test           D  9538-5924-4be3-98ff-7475d27aee4f"
              }
            ],
            "type": [
              {
                "coding": [
                  {
                    "system": "http://terminology.hl7.org/CodeSystem/service-type",
                    "code": "498",
                    "display": "Mobile Services"
                  }
                ]
              }
            ]
          }
        ],
        "address": {
          "type": "physical",
          "line": [
            "ZoTIstr. 19"
          ],
          "postalCode": "10117",
          "city": "ZoTI-Town",
          "country": "D"
        },
        "hoursOfOperation": [
          {
            "daysOfWeek": [
              "mon",
              "tue",
              "wed",
              "thu",
              "fri"
            ],
            "openingTime": "08:00:00",
            "closingTime": "18:00:00"
          }
        ],
        "identifier": [
          {
            "system": "https://gematik.de/fhir/NamingSystem/TelematikID",
            "value": "3-01.2.2023001.16.219"
          }
        ],
        "name": "ZoTI_19_TEST-ONLY",
        "position": {
          "latitude": 13.387627883956709,
          "longitude": 52.5226398750957
        },
        "status": "active",
        "telecom": [
          {
            "system": "other",
            "value": "https://erp-pharmacy-serviceprovider.dev.gematik.solutions/delivery_only",
            "use": "mobile",
            "rank": 300
          },
          {
            "system": "other",
            "value": "https://erp-pharmacy-serviceprovider.dev.gematik.solutions/local_delivery/?req=<transactionid>",
            "use": "mobile",
            "rank": 200
          }
        ],
        "type": [
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/service-type",
                "code": "DELEGATOR",
                "display": "eRX Token Receiver"
              }
            ]
          },
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
                "code": "PHARM",
                "display": "pharmacy"
              }
            ]
          },
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
                "code": "OUTPHARM",
                "display": "outpatient pharmacy"
              }
            ]
          }
        ]
      },
      "search": {
        "mode": "match"
      }
    },
    {
      "resource": {
        "id": "6bb20538-5924-4be3-98ff-7475d27aee4f",
        "meta": {
          "lastUpdated": "2023-08-07T10:48:51.845+02:00",
          "versionId": "3"
        },
        "resourceType": "Location",
        "address": {
          "type": "physical",
          "line": [
            "ZoTIstr. 20"
          ],
          "postalCode": "10117",
          "city": "ZoTI-Town",
          "country": "D"
        },
        "hoursOfOperation": [
          {
            "daysOfWeek": [
              "mon",
              "tue",
              "wed",
              "thu",
              "fri"
            ],
            "openingTime": "08:00:00",
            "closingTime": "18:00:00"
          }
        ],
        "identifier": [
          {
            "system": "https://gematik.de/fhir/NamingSystem/TelematikID",
            "value": "3-01.2.2023001.16.220"
          }
        ],
        "name": "ZoTI_20_TEST-ONLY",
        "position": {
          "latitude": 13.387627883956709,
          "longitude": 52.5226398750957
        },
        "status": "active",
        "type": [
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/service-type",
                "code": "DELEGATOR",
                "display": "eRX Token Receiver"
              }
            ]
          },
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
                "code": "OUTPHARM",
                "display": "outpatient pharmacy"
              }
            ]
          },
          {
            "coding": [
              {
                "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
                "code": "MOBL",
                "display": "Mobile Services"
              }
            ]
          }
        ]
      },
      "search": {
        "mode": "match"
      }
    }
  ]
}"""
    private val jsonMockedData = json.parseToJsonElement(jsonStringMocked)
    private val extractedPharmacies =
        extractPharmacyServices(
            bundle = jsonMockedData,
            onError = { jsonElement, cause ->
                Napier.e(cause) {
                    jsonElement.toString()
                }
            }
        )
}
