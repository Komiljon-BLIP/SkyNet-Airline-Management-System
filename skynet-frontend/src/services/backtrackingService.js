import api from "./api";

export const findBacktrackingRoute = async (
  source,
  destination
) => {

  const response =
    await api.get(
      `/routes/backtracking?source=${source}&destination=${destination}`
    );

  return response.data;
};