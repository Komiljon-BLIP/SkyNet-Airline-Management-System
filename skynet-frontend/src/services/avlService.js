import api from "./api";

export const searchFlightsByPrice = async (
  min,
  max
) => {

  const response =
    await api.get(
      `/flights/tree/range?min=${min}&max=${max}`
    );

  return response.data;
};