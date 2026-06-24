const API_URL =
    "http://localhost:8080";

export async function getAllSpecializations() {

    const response = await fetch(

        `${API_URL}/specializations`

    );

    return await response.json();
}