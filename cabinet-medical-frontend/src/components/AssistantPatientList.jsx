import {

    useTranslation

} from "react-i18next";

import "../styles/AssistantPatientList.css";

function AssistantPatientList({

                                  patients,

                                  medicalRecords,

                                  doctors,

                                  filterType,

                                  onSelect

                              }) {

    const {

        t

    } = useTranslation();

    return (

        <div className="patient-panel">

            <h2>

                {t("patients")}

            </h2>

            {

                patients.map(

                    patient => {

                        const record =

                            medicalRecords.find(

                                r =>

                                    r.patientId ===

                                    patient.id

                            );

                        const doctor =

                            record

                                ?

                                doctors.find(

                                    d =>

                                        d.id ===

                                        record.doctorId

                                )

                                :

                                null;

                        return (

                            <div

                                key={patient.id}

                                className="patient-item"

                                onClick={() =>
                                    onSelect(
                                        patient
                                    )
                                }

                            >

                                <strong>

                                    {patient.firstName}

                                    {" "}

                                    {patient.lastName}

                                </strong>

                                {

                                    filterType ===
                                    "diagnosis"

                                    &&

                                    record

                                    &&

                                    (

                                        <p>

                                            {t("diagnosis")}:

                                            {" "}

                                            {

                                                record.diagnosis

                                            }

                                        </p>

                                    )

                                }

                                {

                                    filterType ===
                                    "doctor"

                                    &&

                                    doctor

                                    &&

                                    (

                                        <p>

                                            {t("doctor")}:

                                            {" "}

                                            Dr.

                                            {" "}

                                            {

                                                doctor.firstName

                                            }

                                            {" "}

                                            {

                                                doctor.lastName

                                            }

                                        </p>

                                    )

                                }

                            </div>

                        );

                    }

                )

            }

        </div>

    );

}

export default AssistantPatientList;