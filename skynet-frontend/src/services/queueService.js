import api from "./api";

export const getBoardingQueue = async () => {

  const response =
    await api.get("/boarding");

  return response.data;
};