const API_URL =
    "http://localhost:8080";

export async function getMedicalRecordsByDoctorId(

    doctorId

) {

    const response =
        await fetch(

            `${API_URL}/medical-records/doctor/${doctorId}`

        );

    return await response.json();
}

export async function updateMedicalRecord(

    record

) {

    const response =
        await fetch(

            `${API_URL}/medical-records`,

            {

                method: "PUT",

                headers: {

                    "Content-Type":
                        "application/json"

                },

                body: JSON.stringify(

                    {

                        id: record.id,

                        symptoms:
                        record.symptoms,

                        diagnosis:
                        record.diagnosis,

                        treatment:
                        record.treatment

                    }

                )

            }

        );

    return await response.json();
}
export async function getAllMedicalRecords() {

    const response =
        await fetch(

            `${API_URL}/medical-records`

        );

    return await response.json();
}