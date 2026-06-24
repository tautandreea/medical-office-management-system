const API_URL =
    "http://localhost:8080";

export async function getStatistics(
    type
) {

    const response =
        await fetch(

            `${API_URL}/statistics/${type}`

        );

    return await response.json();
}