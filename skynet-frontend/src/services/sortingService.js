import api from "./api";

export const runQuickSort = async () => {

  const response =
    await api.get("/sorting/quick");

  return response.data;
};

export const runMergeSort = async () => {

  const response =
    await api.get("/sorting/merge");

  return response.data;
};