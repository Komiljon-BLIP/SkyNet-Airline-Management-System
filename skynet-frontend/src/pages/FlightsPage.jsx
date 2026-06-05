import { useEffect, useState } from "react";
import Sidebar from "../components/Sidebar";
import { getFlights } from "../services/flightService";

export default function FlightsPage() {

  const [flights, setFlights] = useState([]);

  useEffect(() => {

    getFlights()
      .then(data => {
        setFlights(data);
      })
      .catch(error => {
        console.error(error);
      });

  }, []);

  return (

    <div className="flex bg-slate-100 min-h-screen">

      <Sidebar />

      <div className="flex-1 p-8">

        {/* Header */}

        <h1 className="text-4xl font-bold">
          Flight Management
        </h1>

        <p className="text-gray-600 mt-2">
          Manage and monitor airline flights across the SkyNet network.
        </p>

        {/* Statistics Card */}

        <div className="mt-6 bg-white rounded-2xl shadow p-6 inline-block">

          <p className="text-gray-500">
            Total Flights
          </p>

          <h2 className="text-4xl font-bold text-indigo-600">
            {flights.length.toLocaleString()}
          </h2>

        </div>

        {/* Flight Table Card */}

        <div className="mt-8 bg-white rounded-2xl shadow overflow-hidden">

          <div className="p-6 border-b">

            <h2 className="text-2xl font-bold">
              Flight Records
            </h2>

            <p className="text-gray-500 mt-1">
              Showing all available flights in the system.
            </p>

          </div>

          <div className="overflow-auto max-h-[700px]">

            <table className="w-full">

              <thead>

                <tr className="bg-slate-100 border-b">

                  <th className="p-4 text-left">
                    Flight ID
                  </th>

                  <th className="p-4 text-left">
                    Source Airport
                  </th>

                  <th className="p-4 text-left">
                    Destination Airport
                  </th>

                  <th className="p-4 text-left">
                    Ticket Cost
                  </th>

                </tr>

              </thead>

              <tbody>

                {flights.map((flight) => (

                  <tr
                    key={flight.id}
                    className="border-b hover:bg-indigo-50 transition"
                  >

                    <td className="p-4 font-medium">
                      {flight.id}
                    </td>

                    <td className="p-4">
                      {flight.source}
                    </td>

                    <td className="p-4">
                      {flight.destination}
                    </td>

                    <td className="p-4">

                      <span className="
                        px-3
                        py-1
                        rounded-full
                        bg-green-100
                        text-green-700
                        font-semibold
                      ">
                        ${flight.cost}
                      </span>

                    </td>

                  </tr>

                ))}

              </tbody>

            </table>

          </div>

        </div>

        {/* Footer Card */}

        <div className="bg-white rounded-2xl shadow p-6 mt-8">

          <h2 className="text-xl font-bold mb-3">
            Flight Dataset Overview
          </h2>

          <p className="text-gray-600 leading-relaxed">
            The flight dataset is used throughout the platform
            to demonstrate route optimization using Dijkstra's
            Algorithm, flight range searching with AVL Trees,
            sorting benchmarks using QuickSort and MergeSort,
            and backtracking-based route discovery.
          </p>

        </div>

      </div>

    </div>

  );
}