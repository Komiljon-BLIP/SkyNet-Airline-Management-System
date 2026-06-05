import api from "./api";

export const searchByPNR = async (pnr) => {

  const response =
    await api.get(
      `/passengers/hash?pnr=${pnr}`
    );

  return response.data;
};