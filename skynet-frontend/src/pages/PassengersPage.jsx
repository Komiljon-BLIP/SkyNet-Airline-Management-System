import { useEffect, useState } from "react";
import Sidebar from "../components/Sidebar";
import { getPassengers } from "../services/passengerService";
import { searchByPNR } from "../services/hashService";

export default function PassengersPage() {

  const [passengers, setPassengers] = useState([]);
  const [pnr, setPnr] = useState("");
  const [result, setResult] = useState(null);

  useEffect(() => {

    getPassengers()
      .then(data => {
        setPassengers(data);
      })
      .catch(error => {
        console.error(error);
      });

  }, []);

  const handleSearch = async () => {

    try {

      const data = await searchByPNR(pnr);

      setResult(data);

    } catch (error) {

      console.error(error);

      setResult(null);
    }
  };

  const renderStatusBadge = (status) => {

    if (status === "PLATINUM") {

      return (
        <span className="px-3 py-1 rounded-full bg-purple-100 text-purple-700 font-semibold text-sm">
          PLATINUM
        </span>
      );
    }

    if (status === "GOLD") {

      return (
        <span className="px-3 py-1 rounded-full bg-yellow-100 text-yellow-700 font-semibold text-sm">
          GOLD
        </span>
      );
    }

    return (
      <span className="px-3 py-1 rounded-full bg-gray-100 text-gray-700 font-semibold text-sm">
        ECONOMY
      </span>
    );
  };

  return (

    <div className="flex bg-slate-100 min-h-screen">

      <Sidebar />

      <div className="flex-1 p-8">

        {/* Header */}

        <h1 className="text-4xl font-bold">
          Passenger Management
        </h1>

        <p className="text-gray-600 mt-2">
          Manage and search airline passengers using Hash Table lookup.
        </p>

        {/* Statistics Card */}

        <div className="mt-6 bg-white rounded-2xl shadow p-6 inline-block">

          <p className="text-gray-500">
            Total Passengers
          </p>

          <h2 className="text-4xl font-bold text-indigo-600">
            {passengers.length.toLocaleString()}
          </h2>

        </div>

        {/* Search Section */}

        <div className="bg-white rounded-2xl shadow p-6 mt-6">

          <h2 className="text-2xl font-bold mb-2">
            Passenger PNR Search
          </h2>

          <p className="text-gray-500 mb-4">
            Demonstrates Hash Table lookup with O(1)
            average search complexity.
          </p>

          <div className="flex flex-col md:flex-row gap-4">

            <input
              type="text"
              placeholder="Enter PNR (e.g. PNR500)"
              value={pnr}
              onChange={(e) => setPnr(e.target.value)}
              className="border rounded-xl px-4 py-2 w-full md:w-80"
            />

            <button
              onClick={handleSearch}
              className="bg-indigo-600 hover:bg-indigo-700 text-white px-6 py-2 rounded-xl transition"
            >
              Search Passenger
            </button>

          </div>

        </div>

        {/* Search Result */}

        {result && (

          <div className="bg-white shadow rounded-2xl p-6 mt-6 border-l-4 border-green-500">

            <h2 className="font-bold text-xl mb-4 text-green-700">
              Passenger Found
            </h2>

            <div className="grid md:grid-cols-2 gap-4">

              <p>
                <strong>ID:</strong> {result.id}
              </p>

              <p>
                <strong>Name:</strong> {result.name}
              </p>

              <p>
                <strong>PNR:</strong> {result.pnr}
              </p>

              <p>
                <strong>Status:</strong>{" "}
                {renderStatusBadge(result.status)}
              </p>

            </div>

          </div>

        )}

        {/* Passenger Table */}

        <div className="mt-8 bg-white rounded-2xl shadow overflow-hidden">

          <div className="p-6 border-b">

            <h2 className="text-2xl font-bold">
              Passenger Records
            </h2>

            <p className="text-gray-500 mt-1">
              Complete passenger dataset used throughout the system.
            </p>

          </div>

          <div className="overflow-auto max-h-[700px]">

            <table className="w-full">

              <thead>

                <tr className="bg-slate-100 border-b">

                  <th className="p-4 text-left">
                    ID
                  </th>

                  <th className="p-4 text-left">
                    Name
                  </th>

                  <th className="p-4 text-left">
                    PNR
                  </th>

                  <th className="p-4 text-left">
                    Status
                  </th>

                </tr>

              </thead>

              <tbody>

                {passengers.map((passenger) => (

                  <tr
                    key={passenger.id}
                    className="border-b hover:bg-indigo-50 transition"
                  >

                    <td className="p-4 font-medium">
                      {passenger.id}
                    </td>

                    <td className="p-4">
                      {passenger.name}
                    </td>

                    <td className="p-4">
                      {passenger.pnr}
                    </td>

                    <td className="p-4">
                      {renderStatusBadge(passenger.status)}
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
            Passenger Dataset Overview
          </h2>

          <p className="text-gray-600 leading-relaxed">
            Passenger records are used to demonstrate
            Hash Table searching, KMP Pattern Matching,
            Priority Queue boarding management,
            Queue operations and Stack operations
            within the SkyNet Airline Management System.
          </p>

        </div>

      </div>

    </div>

  );
}