import {

    useTranslation

} from "react-i18next";

import "../styles/DoctorPatientList.css";

function DoctorPatientList({

                               patients,

                               selectedPatient,

                               onSelect

                           }) {

    const { t } =
        useTranslation();

    return (

        <div className="patient-panel">

            <h2>

                {

                    t(
                        "myPatients"
                    )

                }

            </h2>

            {

                patients.length === 0 ? (

                    <p>

                        {

                            t(
                                "noPatients"
                            )

                        }

                    </p>

                ) : (

                    patients.map(

                        patient => (

                            <div

                                key={
                                    patient.id
                                }

                                className={

                                    selectedPatient?.id ===
                                    patient.id

                                        ?

                                        "patient-item active"

                                        :

                                        "patient-item"

                                }

                                onClick={() =>
                                    onSelect(
                                        patient
                                    )
                                }

                            >

                                {patient.firstName}

                                {" "}

                                {patient.lastName}

                            </div>

                        )

                    )

                )

            }

        </div>

    );
}

export default DoctorPatientList;