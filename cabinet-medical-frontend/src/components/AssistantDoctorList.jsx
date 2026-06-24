import {

    useTranslation

} from "react-i18next";

import "../styles/AssistantDoctorList.css";

function AssistantDoctorList({

                                 doctors,

                                 onSelect

                             }) {

    const {

        t

    } = useTranslation();

    return (

        <div className="doctor-panel">

            <h2>

                {t("doctors")}

            </h2>

            {

                doctors.map(

                    doctor => (

                        <div

                            key={
                                doctor.id
                            }

                            className="doctor-item"

                            onClick={() =>
                                onSelect(
                                    doctor
                                )
                            }

                        >

                            Dr.

                            {" "}

                            {

                                doctor.firstName

                            }

                            {" "}

                            {

                                doctor.lastName

                            }

                        </div>

                    )

                )

            }

        </div>

    );
}

export default AssistantDoctorList;