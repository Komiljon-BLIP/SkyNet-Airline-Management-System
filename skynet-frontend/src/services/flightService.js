import api from "./api";

export const getFlights = async () => {
    const response = await api.get("/flights");
    return response.data;
};