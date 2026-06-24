const API_URL =
    "http://localhost:8080";

export async function getAllPatients() {

    const response =
        await fetch(

            `${API_URL}/patients`

        );

    return await response.json();
}

export async function createPatient(

    patient

) {

    const response =
        await fetch(

            `${API_URL}/patients`,

            {

                method: "POST",

                headers: {

                    "Content-Type":
                        "application/json"

                },

                body: JSON.stringify(
                    patient
                )

            }

        );

    return await response.json();
}

export async function updatePatient(

    patient

) {

    const response =
        await fetch(

            `${API_URL}/patients`,

            {

                method: "PUT",

                headers: {

                    "Content-Type":
                        "application/json"

                },

                body: JSON.stringify(
                    patient
                )

            }

        );

    return await response.json();
}

export async function deletePatient(

    patientId

) {

    const response =
        await fetch(

            `${API_URL}/patients/${patientId}`,

            {

                method: "DELETE"

            }

        );

    return await response.json();
}