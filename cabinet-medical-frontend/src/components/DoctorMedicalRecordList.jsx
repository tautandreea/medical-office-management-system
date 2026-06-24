import {

    useTranslation

} from "react-i18next";

import "../styles/DoctorMedicalRecordList.css";

function DoctorMedicalRecordList({

                                     records,

                                     selectedPatient,

                                     onSelectRecord

                                 }) {

    const { t } =
        useTranslation();

    if (!selectedPatient) {

        return (

            <div className="record-panel">

                {

                    t(
                        "selectPatient"
                    )

                }

            </div>

        );
    }

    const patientRecords =

        records.filter(

            record =>

                record.patientId ===

                selectedPatient.id

        );

    return (

        <div className="record-panel">

            <h2>

                {

                    t(
                        "medicalRecords"
                    )

                }

            </h2>

            {

                patientRecords.length === 0 ? (

                    <p>

                        {

                            t(
                                "noMedicalRecords"
                            )

                        }

                    </p>

                ) : (

                    patientRecords.map(

                        record => (

                            <div

                                key={
                                    record.id
                                }

                                className="record-item"

                                onClick={() =>
                                    onSelectRecord(
                                        record
                                    )
                                }

                            >

                                {

                                    record.diagnosis

                                }

                            </div>

                        )

                    )

                )

            }

        </div>

    );
}

export default DoctorMedicalRecordList;