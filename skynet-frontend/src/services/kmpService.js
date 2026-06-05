import api from "./api";

export const runKMPSearch = async (pattern) => {

  const response =
    await api.get(
      `/search?pattern=${pattern}`
    );

  return response.data;
};