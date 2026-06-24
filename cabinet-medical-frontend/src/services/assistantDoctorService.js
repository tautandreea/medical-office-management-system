const API_URL =
    "http://localhost:8080";

export async function getAllDoctors() {

    const response =
        await fetch(

            `${API_URL}/doctors`

        );

    return await response.json();
}

export async function createDoctor(

    doctor

) {

    const response =
        await fetch(

            `${API_URL}/doctors`,

            {

                method: "POST",

                headers: {

                    "Content-Type":
                        "application/json"

                },

                body:
                    JSON.stringify(
                        doctor
                    )

            }

        );

    return await response.json();
}

export async function updateDoctor(

    doctor

) {

    const response =
        await fetch(

            `${API_URL}/doctors`,

            {

                method: "PUT",

                headers: {

                    "Content-Type":
                        "application/json"

                },

                body:
                    JSON.stringify(
                        doctor
                    )

            }

        );

    return await response.json();
}

export async function deleteDoctor(

    doctorId

) {

    const response =
        await fetch(

            `${API_URL}/doctors/${doctorId}`,

            {

                method: "DELETE"

            }

        );

    return await response.json();
}