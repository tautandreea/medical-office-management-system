const API_URL =
    "http://localhost:8080";

export async function getPatientById(

    patientId

) {

    const response =
        await fetch(

            `${API_URL}/patients/${patientId}`

        );

    return await response.json();
}
export async function getAllPatients() {

    const response =
        await fetch(

            `${API_URL}/patients`

        );

    return await response.json();
}