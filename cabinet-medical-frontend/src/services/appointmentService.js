const API_URL =
    "http://localhost:8080";

export async function getAllAppointments() {

    const response =
        await fetch(

            `${API_URL}/appointments`

        );

    return await response.json();
}

export async function getAppointmentsByDoctorId(

    doctorId

) {

    const response =
        await fetch(

            `${API_URL}/appointments/doctor/${doctorId}`

        );

    return await response.json();
}

export async function createAppointment(

    appointment

) {

    const response =
        await fetch(

            `${API_URL}/appointments`,

            {

                method: "POST",

                headers: {

                    "Content-Type":
                        "application/json"

                },

                body:
                    JSON.stringify(
                        appointment
                    )

            }

        );

    return await response.json();
}

export async function deleteAppointment(

    appointmentId

) {

    const response =
        await fetch(

            `${API_URL}/appointments/${appointmentId}`,

            {

                method: "DELETE"

            }

        );

    return await response.json();
}