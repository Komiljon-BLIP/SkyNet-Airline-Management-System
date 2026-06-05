import { useEffect, useState } from "react";
import Sidebar from "../components/Sidebar";
import api from "../services/api";

export default function DashboardPage() {

  const [stats, setStats] = useState({
    airports: 0,
    flights: 0,
    passengers: 0,
    algorithms: 0
  });

  useEffect(() => {

    api.get("/dashboard/stats")
      .then(response => {

        setStats(response.data);

      })
      .catch(error => {

        console.error(error);

      });

  }, []);

  return (

    <div className="flex bg-slate-100 min-h-screen">

      <Sidebar />

      <div className="flex-1 p-8">

        {/* Hero Banner */}

        <div className="bg-gradient-to-r from-indigo-600 to-blue-700 text-white rounded-2xl shadow-lg p-8">

          <h1 className="text-5xl font-bold">
            SkyNet Airline Analytics Platform
          </h1>

          <p className="mt-4 text-indigo-100 max-w-4xl leading-relaxed">
            A full-stack airline management platform designed to
            demonstrate real-world applications of Data Structures
            and Algorithms including Hash Tables, AVL Trees,
            Graph Algorithms, Sorting Algorithms, Priority Queues,
            Queues, Stacks, Pattern Matching and Route Optimization.
          </p>

        </div>

        {/* Statistics */}

        <div className="grid grid-cols-2 md:grid-cols-4 gap-6 mt-8">

          <div className="bg-white rounded-2xl shadow p-6 hover:shadow-xl hover:-translate-y-1 transition duration-300">

            <p className="text-gray-500">
              Airports
            </p>

            <h2 className="text-4xl font-bold text-indigo-600 mt-2">
              {stats.airports}
            </h2>

          </div>

          <div className="bg-white rounded-2xl shadow p-6 hover:shadow-xl hover:-translate-y-1 transition duration-300">

            <p className="text-gray-500">
              Flights
            </p>

            <h2 className="text-4xl font-bold text-indigo-600 mt-2">
              {stats.flights.toLocaleString()}
            </h2>

          </div>

          <div className="bg-white rounded-2xl shadow p-6 hover:shadow-xl hover:-translate-y-1 transition duration-300">

            <p className="text-gray-500">
              Passengers
            </p>

            <h2 className="text-4xl font-bold text-indigo-600 mt-2">
              {stats.passengers.toLocaleString()}
            </h2>

          </div>

          <div className="bg-white rounded-2xl shadow p-6 hover:shadow-xl hover:-translate-y-1 transition duration-300">

            <p className="text-gray-500">
              Algorithms
            </p>

            <h2 className="text-4xl font-bold text-indigo-600 mt-2">
              {stats.algorithms}
            </h2>

          </div>

        </div>

        {/* DSA Technologies */}

        <div className="bg-white rounded-2xl shadow p-6 mt-8">

          <h2 className="text-2xl font-bold mb-4">
            Implemented Data Structures & Algorithms
          </h2>

          <div className="flex flex-wrap gap-3">

            {[
              "Hash Table",
              "AVL Tree",
              "Dijkstra",
              "KMP Search",
              "Backtracking",
              "QuickSort",
              "MergeSort",
              "Priority Queue",
              "Queue",
              "Stack"
            ].map((item, index) => (

              <span
                key={index}
                className="
                  px-4
                  py-2
                  rounded-full
                  bg-indigo-100
                  text-indigo-700
                  font-medium
                "
              >
                {item}
              </span>

            ))}

          </div>

        </div>

        {/* System Overview */}

        <div className="bg-white rounded-2xl shadow p-6 mt-8">

          <h2 className="text-2xl font-bold mb-6">
            System Overview
          </h2>

          <div className="grid md:grid-cols-3 gap-6">

            <div className="bg-slate-50 rounded-xl p-5">

              <h3 className="font-bold text-lg">
                Passenger Management
              </h3>

              <p className="text-gray-600 mt-3">
                Efficient passenger retrieval using
                Hash Tables and KMP Pattern Matching
                for high-performance search operations.
              </p>

            </div>

            <div className="bg-slate-50 rounded-xl p-5">

              <h3 className="font-bold text-lg">
                Flight Optimization
              </h3>

              <p className="text-gray-600 mt-3">
                Route discovery and shortest-path
                calculation using Dijkstra and
                Backtracking algorithms.
              </p>

            </div>

            <div className="bg-slate-50 rounded-xl p-5">

              <h3 className="font-bold text-lg">
                Performance Analytics
              </h3>

              <p className="text-gray-600 mt-3">
                Sorting benchmarks, AVL Tree searching
                and real-time DSA demonstrations
                across airline datasets.
              </p>

            </div>

          </div>

        </div>

        {/* Project Overview */}

        <div className="bg-white rounded-2xl shadow p-6 mt-8">

          <h2 className="text-2xl font-bold mb-4">
            Project Overview
          </h2>

          <p className="text-gray-600 leading-relaxed">

            SkyNet is a Data Structures and Algorithms
            demonstration platform developed to showcase
            how classical computer science concepts can
            solve real-world airline management problems.

            The platform integrates route optimization,
            passenger search, flight analytics, boarding
            prioritization, queue management and sorting
            performance evaluation into a single system.

          </p>

        </div>

      </div>

    </div>

  );
}