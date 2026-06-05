import { BrowserRouter, Routes, Route } from "react-router-dom";

import DashboardPage from "../pages/DashboardPage";
import FlightsPage from "../pages/FlightsPage";
import PassengersPage from "../pages/PassengersPage";
import AnalyticsPage from "../pages/AnalyticsPage";

export default function AppRoutes() {
  return (
    <BrowserRouter>
      <Routes>

        <Route
          path="/"
          element={<DashboardPage />}
        />

        <Route
          path="/flights"
          element={<FlightsPage />}
        />

        <Route
          path="/passengers"
          element={<PassengersPage />}
        />

        <Route
          path="/analytics"
          element={<AnalyticsPage />}
        />

      </Routes>
    </BrowserRouter>
  );
}