const API_URL =
    "http://localhost:8080";

export async function getAllDoctors() {

    const response = await fetch(

        `${API_URL}/doctors`

    );

    return await response.json();
}