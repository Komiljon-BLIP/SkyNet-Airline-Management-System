import api from "./api";

export const getPassengers = async () => {
    const response = await api.get("/passengers");
    return response.data;
};