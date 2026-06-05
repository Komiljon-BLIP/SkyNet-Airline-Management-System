// AnalyticsPage.jsx
import { useEffect, useState } from "react";
import Sidebar from "../components/Sidebar";
import { getAnalytics } from "../services/analyticsService";
import { findRoute } from "../services/dijkstraService";
import { searchFlightsByPrice } from "../services/avlService";
import {runQuickSort,runMergeSort} from "../services/sortingService";
import { runKMPSearch } from "../services/kmpService";
import {findBacktrackingRoute} from "../services/backtrackingService";
import {getPriorityQueue} from "../services/priorityQueueService";
import {getBoardingQueue } from "../services/queueService";
import {getCargoStack } from "../services/stackService";

export default function AnalyticsPage() {

  const [algorithms, setAlgorithms] = useState([]);

  // Dijkstra
  const [source, setSource] = useState("");
  const [destination, setDestination] = useState("");
  const [routeResult, setRouteResult] = useState(null);

  // AVL
  const [minPrice, setMinPrice] = useState("");
  const [maxPrice, setMaxPrice] = useState("");
  const [avlResults, setAvlResults] = useState([]);

  // Sorting
  const [quickResult, setQuickResult] = useState(null);
  const [mergeResult, setMergeResult] = useState(null);

  // Seaching
  const [searchPattern, setSearchPattern] = useState("");
  const [kmpResult, setKmpResult] = useState(null);
  // Backtracking
  const [backSource, setBackSource] = useState("");
  const [backDestination, setBackDestination] = useState("");
  const [backtrackingResult, setBacktrackingResult] = useState(null);

  // PriorityQueue
  const [priorityPassengers,setPriorityPassengers]= useState([]);
  //Queue
  const [queuePassengers,setQueuePassengers] = useState([]);
  // Stack
  const [stackPassengers, setStackPassengers] = useState([]);




  useEffect(() => {

    getAnalytics()
      .then(data => {
        setAlgorithms(data);
      })
      .catch(error => {
        console.error(error);
      });

  }, []);

  // =========================
  // DIJKSTRA
  // =========================

  const handleDijkstra = async () => {

    try {

      const data =
        await findRoute(
          source,
          destination
        );

      setRouteResult(data);

    } catch (error) {

      console.error(error);

      alert("Route not found");
    }
  };

  // =========================
  // AVL
  // =========================

  const handleAVLSearch = async () => {

    try {

      const data =
        await searchFlightsByPrice(
          minPrice,
          maxPrice
        );

      setAvlResults(data);

    } catch (error) {

      console.error(error);

      alert("Search failed");
    }
  };

  // =========================
  // QUICK SORT
  // =========================

  const handleQuickSort = async () => {

    try {

      const data =
        await runQuickSort();

      setQuickResult(data);

    } catch (error) {

      console.error(error);
    }
  };

  // =========================
  // MERGE SORT
  // =========================

  const handleMergeSort = async () => {

    try {

      const data =
        await runMergeSort();

      setMergeResult(data);

    } catch (error) {

      console.error(error);
    }
  };
  // =========================
  // Searching
  // =========================
  const handleKMP = async () => {

    try {
  
      const data =
        await runKMPSearch(
          searchPattern
        );
  
      setKmpResult(data);
  
    } catch (error) {
  
      console.error(error);
    }
  };
  // =========================
  // Backtracking
  // =========================
  const handleBacktracking = async () => {

    try {
  
      const data =
        await findBacktrackingRoute(
          backSource,
          backDestination
        );
  
      setBacktrackingResult(data);
  
    } catch (error) {
  
      console.error(error);
    }
  };
  // =========================
  // PriorityQueue
  // =========================
  const handlePriorityQueue = async () => {

    try {
  
      const data =
        await getPriorityQueue();
  
      setPriorityPassengers(data);
  
    } catch (error) {
  
      console.error(error);
    }
  };
  // =========================
  // Queue
  // =========================
  const handleQueue = async () => {

    try {
  
      const data =
        await getBoardingQueue();
  
      setQueuePassengers(data);
  
    } catch (error) {
  
      console.error(error);
    }
  };
  // =========================
  // Stack
  // =========================
  const handleStack = async () => {

    try {
  
      const data =
        await getCargoStack();
  
      setStackPassengers(data);
  
    } catch (error) {
  
      console.error(error);
    }
  };



  return (

    <div className="flex">

      <Sidebar />

      <div className="flex-1 p-8 bg-slate-100 min-h-screen">

      <div className="bg-gradient-to-r from-indigo-600 to-blue-700 text-white rounded-2xl p-8 shadow-lg">

<h1 className="text-4xl font-bold">
  SkyNet DSA Analytics
</h1>

<p className="mt-3 text-indigo-100">
  Interactive demonstration of Data Structures & Algorithms
  used in real-world airline management systems.
</p>

</div>
        {/* ========================= */}
        {/* DIJKSTRA */}
        {/* ========================= */}

        <div className="bg-white rounded-xl shadow p-6 mt-8">

          <h2 className="text-2xl font-bold mb-4">
            Dijkstra Route Finder
          </h2>

          <div className="flex flex-col md:flex-row gap-4">

            <input
              type="text"
              placeholder="Source Airport (APT1)"
              value={source}
              onChange={(e) =>
                setSource(e.target.value)
              }
              className="border rounded-lg px-4 py-2"
            />

            <input
              type="text"
              placeholder="Destination Airport (APT50)"
              value={destination}
              onChange={(e) =>
                setDestination(e.target.value)
              }
              className="border rounded-lg px-4 py-2"
            />

            <button
              onClick={handleDijkstra}
              className="bg-indigo-600 text-white px-6 py-2 rounded-xl hover:bg-indigo-700 transition"
            >
              Find Route
            </button>

          </div>

          {routeResult && (

            <div className="mt-6 bg-green-50 border border-green-200 rounded-xl p-4">

              <h3 className="font-bold text-lg">
                Shortest Route
              </h3>

              <p className="mt-2 text-green-700 text-lg">
                {routeResult.path.join(" → ")}
              </p>

              <p className="mt-3">
                <strong>Total Cost:</strong>
                {" "}
                {routeResult.totalCost}
              </p>

            </div>

          )}

        </div>

        {/* ========================= */}
        {/* AVL TREE */}
        {/* ========================= */}

        <div className="bg-white rounded-xl shadow p-6 mt-8">

          <h2 className="text-2xl font-bold mb-4">
            AVL Tree Flight Price Search
          </h2>

          <div className="flex flex-col md:flex-row gap-4">

            <input
              type="number"
              placeholder="Minimum Price"
              value={minPrice}
              onChange={(e) =>
                setMinPrice(e.target.value)
              }
              className="border rounded-lg px-4 py-2"
            />

            <input
              type="number"
              placeholder="Maximum Price"
              value={maxPrice}
              onChange={(e) =>
                setMaxPrice(e.target.value)
              }
              className="border rounded-lg px-4 py-2"
            />

            <button
              onClick={handleAVLSearch}
              className="bg-indigo-600 text-white px-6 py-2 rounded-xl hover:bg-indigo-700 transition"
            >
              Search Flights
            </button>

          </div>

          {avlResults.length > 0 && (

            <div className="mt-6">

              <h3 className="font-bold text-lg">
                Results Found: {avlResults.length}
              </h3>

              <div className="overflow-auto max-h-72 mt-4">

                <table className="w-full">

                  <thead>

                    <tr className="border-b">

                      <th className="text-left p-2">
                        Source
                      </th>

                      <th className="text-left p-2">
                        Destination
                      </th>

                      <th className="text-left p-2">
                        Cost
                      </th>

                    </tr>

                  </thead>

                  <tbody>

                    {avlResults
                      .slice(0, 50)
                      .map((flight) => (

                      <tr
                        key={flight.id}
                        className="border-b"
                      >

                        <td className="p-2">
                          {flight.source}
                        </td>

                        <td className="p-2">
                          {flight.destination}
                        </td>

                        <td className="p-2">
                          ${flight.cost}
                        </td>

                      </tr>

                    ))}

                  </tbody>

                </table>

              </div>

            </div>

          )}

        </div>

        {/* ========================= */}
        {/* SORTING BENCHMARKS */}
        {/* ========================= */}

        <div className="bg-white rounded-xl shadow p-6 mt-8">

          <h2 className="text-2xl font-bold mb-4">
            Sorting Performance Benchmarks
          </h2>

          <div className="flex flex-col md:flex-row gap-4">

            <button
              onClick={handleQuickSort}
              className="bg-indigo-600 text-white px-6 py-2 rounded-xl hover:bg-indigo-700 transition"
            >
              Run QuickSort
            </button>

            <button
              onClick={handleMergeSort}
              className="bg-indigo-600 text-white px-6 py-2 rounded-xl hover:bg-indigo-700 transition"
            >
              Run MergeSort
            </button>

          </div>

          <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">

            {quickResult && (

              <div className="bg-purple-50 border rounded-xl p-4">

                <h3 className="font-bold">
                  {quickResult.algorithm}
                </h3>

                <p>
                  Execution Time:
                  {" "}
                  {quickResult.executionTimeMs}
                  ms
                </p>

                <p>
                  Records Processed:
                  {" "}
                  {quickResult.recordsProcessed}
                </p>

              </div>

            )}

            {mergeResult && (

              <div className="bg-orange-50 border rounded-xl p-4">

                <h3 className="font-bold">
                  {mergeResult.algorithm}
                </h3>

                <p>
                  Execution Time:
                  {" "}
                  {mergeResult.executionTimeMs}
                  ms
                </p>

                <p>
                  Records Processed:
                  {" "}
                  {mergeResult.recordsProcessed}
                </p>

              </div>

            )}

          </div>

        </div>
{/* ========================= */}
{/* KMP SEARCH */}
{/* ========================= */}

<div className="bg-white rounded-xl shadow p-6 mt-8">

<h2 className="text-2xl font-bold mb-4">
  KMP Passenger Search
</h2>

<p className="text-gray-600 mb-4">
  Search passenger names using the
  Knuth-Morris-Pratt string matching algorithm.
</p>

<div className="flex flex-col md:flex-row gap-4">

  <input
    type="text"
    placeholder="Enter name pattern"
    value={searchPattern}
    onChange={(e) =>
      setSearchPattern(e.target.value)
    }
    className="border rounded-lg px-4 py-2"
  />

  <button
    onClick={handleKMP}
    className="bg-indigo-600 text-white px-6 py-2 rounded-lg hover:bg-indigo-700"
  >
    Run KMP Search
  </button>

</div>

{kmpResult && (

<div className="bg-white shadow rounded-2xl p-6 mt-6 border-l-4 border-indigo-600">

    <h3 className="font-bold text-lg">
      Search Results
    </h3>

    <p className="mt-2">
      <strong>Pattern:</strong>
      {" "}
      {kmpResult.pattern}
    </p>

    <p>
  Search Term:
  {" "}
  {kmpResult.searchTerm}
</p>

<p>
  Matches Found:
  {" "}
  {kmpResult.matchesFound}
</p>

<p>
  Execution Time:
  {" "}
  {kmpResult.executionTimeMs}
  ms
</p>

  </div>

)}

</div>


{/* ========================= */}
{/* BACKTRACKING */}
{/* ========================= */}

<div className="bg-white rounded-xl shadow p-6 mt-8">

  <h2 className="text-2xl font-bold mb-4">
    Backtracking Route Explorer
  </h2>

  <div className="flex flex-col md:flex-row gap-4">

    <input
      type="text"
      placeholder="Source Airport"
      value={backSource}
      onChange={(e) =>
        setBackSource(e.target.value)
      }
      className="border rounded-lg px-4 py-2"
    />

    <input
      type="text"
      placeholder="Destination Airport"
      value={backDestination}
      onChange={(e) =>
        setBackDestination(e.target.value)
      }
      className="border rounded-lg px-4 py-2"
    />

    <button
      onClick={handleBacktracking}
      className="bg-indigo-600 text-white px-6 py-2 rounded-xl hover:bg-indigo-700 transition"
    >
      Find Route
    </button>

  </div>

  {backtrackingResult && (

<div className="bg-red-50 border rounded-xl p-4 mt-6 max-h-48 overflow-auto">

      <h3 className="font-bold">
        Route Found
      </h3>

      <p className="mt-2">

      {backtrackingResult.route.join(" → ")}

      </p>

      <p className="mt-3">

        Routes Found:
        {" "}
        {backtrackingResult.routesFound}

      </p>

    </div>

  )}

</div>
{/* ========================= */}
{/* PRIORITY QUEUE */}
{/* ========================= */}

<div className="bg-white rounded-2xl shadow p-6 mt-8">

  <h2 className="text-2xl font-bold mb-2">
    Priority Queue (Heap)
  </h2>

  <p className="text-gray-600 mb-4">
    Prioritizes passengers based on loyalty status
    for airline boarding.
  </p>

  <button
    onClick={handlePriorityQueue}
    className="bg-indigo-600 hover:bg-indigo-700 text-white px-6 py-2 rounded-xl transition"
  >
    Build Priority Queue
  </button>

  {priorityPassengers.length > 0 && (

    <div className="mt-6">

      <div className="flex justify-between items-center">

        <h3 className="font-bold text-lg">
          Priority Boarding Order
        </h3>

        <span className="bg-indigo-100 text-indigo-700 px-3 py-1 rounded-full text-sm">
          Showing first 10 records
        </span>

      </div>

      <div className="overflow-auto max-h-72 mt-4">

        <table className="w-full">

          <thead>

            <tr className="border-b bg-slate-50">

              <th className="text-left p-3">
                Name
              </th>

              <th className="text-left p-3">
                PNR
              </th>

              <th className="text-left p-3">
                Status
              </th>

            </tr>

          </thead>

          <tbody>

            {priorityPassengers
              .slice(0, 10)
              .map((passenger, index) => (

              <tr
                key={index}
                className="border-b hover:bg-slate-50"
              >

                <td className="p-3">
                  {passenger.name}
                </td>

                <td className="p-3">
                  {passenger.pnr}
                </td>

                <td className="p-3">
                  {passenger.status}
                </td>

              </tr>

            ))}

          </tbody>

        </table>

      </div>

    </div>

  )}

</div>
{/* ========================= */}
{/* QUEUE */}
{/* ========================= */}

<div className="bg-white rounded-2xl shadow p-6 mt-8">

  <h2 className="text-2xl font-bold mb-2">
    Queue (FIFO)
  </h2>

  <p className="text-gray-600 mb-4">
    Airport boarding queue using the
    First-In First-Out principle.
  </p>

  <button
    onClick={handleQueue}
    className="bg-indigo-600 hover:bg-indigo-700 text-white px-6 py-2 rounded-xl transition"
  >
    Load Queue
  </button>

  {queuePassengers.length > 0 && (

    <div className="mt-6">

      <div className="flex justify-between items-center">

        <h3 className="font-bold text-lg">
          Boarding Order (FIFO)
        </h3>

        <span className="bg-indigo-100 text-indigo-700 px-3 py-1 rounded-full text-sm">
          Showing first 10 records
        </span>

      </div>

      <div className="overflow-auto max-h-72 mt-4">

        <table className="w-full">

          <thead>

            <tr className="border-b bg-slate-50">

              <th className="text-left p-3">
                Name
              </th>

              <th className="text-left p-3">
                PNR
              </th>

            </tr>

          </thead>

          <tbody>

            {queuePassengers
              .slice(0, 10)
              .map((passenger, index) => (

              <tr
                key={index}
                className="border-b hover:bg-slate-50"
              >

                <td className="p-3">
                  {passenger.name}
                </td>

                <td className="p-3">
                  {passenger.pnr}
                </td>

              </tr>

            ))}

          </tbody>

        </table>

      </div>

    </div>

  )}

</div>
{/* ========================= */}
{/* STACK */}
{/* ========================= */}

<div className="bg-white rounded-2xl shadow p-6 mt-8">

  <h2 className="text-2xl font-bold mb-2">
    Stack (LIFO)
  </h2>

  <p className="text-gray-600 mb-4">
    Cargo loading order using the
    Last-In First-Out principle.
  </p>

  <button
    onClick={handleStack}
    className="bg-indigo-600 hover:bg-indigo-700 text-white px-6 py-2 rounded-xl transition"
  >
    Load Stack
  </button>

  {stackPassengers.length > 0 && (

    <div className="mt-6">

      <div className="flex justify-between items-center">

        <h3 className="font-bold text-lg">
          Cargo Order (LIFO)
        </h3>

        <span className="bg-indigo-100 text-indigo-700 px-3 py-1 rounded-full text-sm">
          Showing first 10 records
        </span>

      </div>

      <div className="overflow-auto max-h-72 mt-4">

        <table className="w-full">

          <thead>

            <tr className="border-b bg-slate-50">

              <th className="text-left p-3">
                Name
              </th>

              <th className="text-left p-3">
                PNR
              </th>

            </tr>

          </thead>

          <tbody>

            {stackPassengers
              .slice(0, 10)
              .map((passenger, index) => (

              <tr
                key={index}
                className="border-b hover:bg-slate-50"
              >

                <td className="p-3">
                  {passenger.name}
                </td>

                <td className="p-3">
                  {passenger.pnr}
                </td>

              </tr>

            ))}

          </tbody>

        </table>

      </div>

    </div>

  )}

</div>



{/* ========================= */}
{/* ALGORITHM CARDS */}
{/* ========================= */}

<div className="mt-12">

  <h2 className="text-3xl font-bold">
    Algorithm Complexity Reference
  </h2>

  <p className="text-gray-600 mt-2">
    Overview of all Data Structures & Algorithms
    implemented in the SkyNet Airline Management System.
  </p>

</div>

<div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6 mt-8">

  {algorithms.map((algo, index) => (

    <div
      key={index}
      className="
        bg-white
        rounded-2xl
        shadow
        p-6
        hover:shadow-xl
        hover:-translate-y-1
        transition
        duration-300
      "
    >

      <span className="text-xs uppercase tracking-wider text-gray-400">
        Data Structures & Algorithms
      </span>

      <h2 className="text-xl font-bold mt-2">
        {algo.algorithm}
      </h2>

      <span
        className="
          inline-block
          bg-indigo-100
          text-indigo-700
          px-3
          py-1
          rounded-full
          font-semibold
          mt-3
        "
      >
        {algo.complexity}
      </span>

      <p className="text-gray-600 mt-4 leading-relaxed">
        {algo.description}
      </p>

    </div>

  ))}

</div>

{/* ========================= */}
{/* ALGORITHM SUMMARY */}
{/* ========================= */}

<div className="bg-white rounded-2xl shadow p-8 mt-10">

  <h2 className="text-2xl font-bold mb-4">
    Algorithm Complexity Summary
  </h2>

  <p className="text-gray-600 leading-relaxed">
    The SkyNet Airline Management System demonstrates
    the practical implementation of fundamental Data
    Structures and Algorithms including Hash Tables,
    AVL Trees, Dijkstra's Shortest Path Algorithm,
    Backtracking, KMP Pattern Matching, QuickSort,
    MergeSort, Priority Queues, Queues and Stacks.
  </p>

</div>

{/* ========================= */}
{/* PROJECT OVERVIEW */}
{/* ========================= */}

<div className="bg-gradient-to-r from-indigo-600 to-blue-700 text-white rounded-2xl shadow-lg p-8 mt-8">

  <h2 className="text-3xl font-bold">
    SkyNet Airline Management System
  </h2>

  <p className="mt-4 text-indigo-100 leading-relaxed">

    A full-stack airline management platform developed
    to demonstrate the application of Data Structures
    and Algorithms in solving real-world business
    problems.

    The system provides passenger management,
    flight management, route optimization,
    search optimization, sorting benchmarks,
    boarding prioritization and analytical
    performance evaluation.

  </p>

  <div className="grid grid-cols-2 md:grid-cols-4 gap-6 mt-8">

    <div className="bg-white/10 rounded-xl p-4">

      <p className="font-bold text-3xl">
        100K
      </p>

      <p className="text-indigo-100">
        Passengers
      </p>

    </div>

    <div className="bg-white/10 rounded-xl p-4">

      <p className="font-bold text-3xl">
        10K
      </p>

      <p className="text-indigo-100">
        Flights
      </p>

    </div>

    <div className="bg-white/10 rounded-xl p-4">

      <p className="font-bold text-3xl">
        100
      </p>

      <p className="text-indigo-100">
        Airports
      </p>

    </div>

    <div className="bg-white/10 rounded-xl p-4">

      <p className="font-bold text-3xl">
        10+
      </p>

      <p className="text-indigo-100">
        Algorithms
      </p>

    </div>

  </div>

</div>

      </div>

    </div>
  );
}
