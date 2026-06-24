const API_URL =
    "http://localhost:8080";

export async function
getMedicalRecordsByPatientId(
    patientId
) {

    const response =
        await fetch(

            `${API_URL}/medical-records/patient/${patientId}`

        );

    return await response.json();
}