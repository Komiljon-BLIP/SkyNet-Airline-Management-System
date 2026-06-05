import api from "./api";

export const getPriorityQueue = async () => {

  const response =
    await api.get("/checkin");

  return response.data;
};