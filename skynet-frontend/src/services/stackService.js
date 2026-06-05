import api from "./api";

export const getCargoStack = async () => {

  const response =
    await api.get("/cargo");

  return response.data;
};