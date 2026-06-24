import { useTranslation }
    from "react-i18next";

import "../styles/MedicalRecordDetails.css";

import {

    exportMedicalRecord

} from "../services/exportService";

function MedicalRecordDetails({

                                  record

                              }) {

    const { t } =
        useTranslation();

    const handleExport =
        async () => {

            try {

                const content =

                    await exportMedicalRecord(

                        record.id

                    );

                const blob =
                    new Blob(

                        [content],

                        {
                            type:
                                "application/msword"
                        }

                    );

                const url =
                    window.URL.createObjectURL(
                        blob
                    );

                const link =
                    document.createElement(
                        "a"
                    );

                link.href =
                    url;

                link.download =

                    `medical-record-${record.id}.doc`;

                document.body.appendChild(
                    link
                );

                link.click();

                document.body.removeChild(
                    link
                );

            } catch (error) {

                console.error(
                    error
                );

                alert(
                    "Export failed!"
                );
            }
        };

    if (!record) {

        return (

            <div className="record-details">

                {t("selectMedicalRecord")}

            </div>

        );
    }

    return (

        <div className="record-details">

            <h2>

                {t("medicalRecord")}

            </h2>

            <p>

                <strong>

                    {t("symptoms")}:

                </strong>

                {" "}

                {record.symptoms}

            </p>

            <p>

                <strong>

                    {t("diagnosis")}:

                </strong>

                {" "}

                {record.diagnosis}

            </p>

            <p>

                <strong>

                    {t("treatment")}:

                </strong>

                {" "}

                {record.treatment}

            </p>

            <button

                className="export-btn"

                onClick={handleExport}

            >

                {t("exportWord")}

            </button>

        </div>

    );
}

export default MedicalRecordDetails;