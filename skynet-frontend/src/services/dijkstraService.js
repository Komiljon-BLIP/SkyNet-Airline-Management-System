import api from "./api";

export const findRoute = async (
  source,
  destination
) => {

  const response =
    await api.get(
      `/dijkstra?source=${source}&destination=${destination}`
    );

  return response.data;
};