import axios from "axios";

export interface Task {
  id?: number;
  title: string;
  description?: string;
  isCompleted?: boolean;
  dueDate?: string;
  assignedTo?: string;
}

const api = axios.create({
  baseURL: "http://localhost:8080/api",
});

export const getTasks = () => api.get("/tasks");

export const createTask = (task: Task) => api.post("/tasks", task);

export const updateTask = (id: number, task: Task) =>
  api.put(`/tasks/${id}`, task);

export const deleteTask = (id: number) => api.delete(`/tasks/${id}`);

export const toggleTask = (id: number) =>
  api.patch(`/tasks/${id}/toggle`);
