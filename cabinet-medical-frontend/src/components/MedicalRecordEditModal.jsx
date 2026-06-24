import {

    useState

} from "react";

import {

    useTranslation

} from "react-i18next";

import "../styles/MedicalRecordEditModal.css";

function MedicalRecordEditModal({

                                    record,

                                    onClose,

                                    onSave

                                }) {

    const { t } =
        useTranslation();

    const [

        symptoms,

        setSymptoms

    ] = useState(

        record.symptoms

    );

    const [

        diagnosis,

        setDiagnosis

    ] = useState(

        record.diagnosis

    );

    const [

        treatment,

        setTreatment

    ] = useState(

        record.treatment

    );

    const handleSave =
        () => {

            onSave({

                ...record,

                symptoms,

                diagnosis,

                treatment

            });
        };

    return (

        <div className="modal-overlay">

            <div className="modal-content">

                <button

                    className="close-btn"

                    onClick={onClose}

                >

                    X

                </button>

                <h2>

                    {

                        t(
                            "editMedicalRecord"
                        )

                    }

                </h2>

                <label>

                    {

                        t(
                            "symptoms"
                        )

                    }

                </label>

                <textarea

                    value={symptoms}

                    onChange={

                        e =>

                            setSymptoms(

                                e.target.value

                            )

                    }

                />

                <label>

                    {

                        t(
                            "diagnosis"
                        )

                    }

                </label>

                <textarea

                    value={diagnosis}

                    onChange={

                        e =>

                            setDiagnosis(

                                e.target.value

                            )

                    }

                />

                <label>

                    {

                        t(
                            "treatment"
                        )

                    }

                </label>

                <textarea

                    value={treatment}

                    onChange={

                        e =>

                            setTreatment(

                                e.target.value

                            )

                    }

                />

                <button

                    className="save-btn"

                    onClick={handleSave}

                >

                    {

                        t(
                            "save"
                        )

                    }

                </button>

            </div>

        </div>

    );
}

export default MedicalRecordEditModal;