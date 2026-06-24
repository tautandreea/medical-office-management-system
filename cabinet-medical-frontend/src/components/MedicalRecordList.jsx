import { useTranslation }
    from "react-i18next";

import "../styles/MedicalRecordList.css";

function MedicalRecordList({

                               records,

                               selectedRecord,

                               onSelect

                           }) {

    const { t } =
        useTranslation();

    return (

        <div className="record-list">

            <h2>

                {t("myMedicalRecords")}

            </h2>

            {

                records.map(

                    record => (

                        <div

                            key={
                                record.id
                            }

                            className={

                                selectedRecord?.id ===
                                record.id

                                    ?

                                    "record-item active"

                                    :

                                    "record-item"

                            }

                            onClick={() =>
                                onSelect(
                                    record
                                )
                            }

                        >

                            {t("medicalRecord")}

                            {" - "}

                            {record.diagnosis}

                        </div>

                    )

                )

            }

        </div>

    );
}

export default MedicalRecordList;