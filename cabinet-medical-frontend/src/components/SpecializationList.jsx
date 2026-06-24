import { useTranslation }
    from "react-i18next";

import "../styles/SpecializationList.css";

function SpecializationList({

                                specializations,

                                selectedSpecialization,

                                onSelect

                            }) {

    const { t } =
        useTranslation();

    return (

        <div className="specialization-panel">

            <h2>

                {t("specializations")}

            </h2>

            {

                specializations.map(

                    specialization => (

                        <button

                            key={
                                specialization.specializationId
                            }

                            className={

                                selectedSpecialization?.specializationId ===
                                specialization.specializationId

                                    ? "specialization-btn active"

                                    : "specialization-btn"

                            }

                            onClick={() =>
                                onSelect(
                                    specialization
                                )
                            }

                        >

                            {specialization.name}

                        </button>

                    )

                )

            }

        </div>

    );
}

export default SpecializationList;