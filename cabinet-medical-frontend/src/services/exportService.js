const API_URL =
    "http://localhost:8080";

export async function exportMedicalRecord(

    recordId

) {

    const response =
        await fetch(

            `${API_URL}/export/medical-records/${recordId}`

        );

    return await response.text();
}
export async function exportPatients(
    format
) {

    const response =
        await fetch(

            `${API_URL}/export/patients/${format}`

        );

    return await response.text();
}

export async function exportDoctors(
    format
) {

    const response =
        await fetch(

            `${API_URL}/export/doctors/${format}`

        );

    return await response.text();
}
export async function exportUsers() {

    const response =
        await fetch(

            `${API_URL}/export/users`

        );

    return await response.text();
}