import { Link } from "react-router-dom";

export default function Sidebar() {

  return (

    <div
      className="
        w-64
        h-screen
        sticky
        top-0
        bg-slate-900
        text-white
        flex
        flex-col
        shadow-xl
      "
    >

      {/* Logo Section */}

      <div className="p-6 border-b border-slate-800">

        <h1 className="text-3xl font-bold">
          SkyNet
        </h1>

        <p className="text-slate-400 text-sm mt-2">
          Airline Analytics Platform
        </p>

      </div>

      {/* Navigation */}

      <nav className="flex-1 p-6 overflow-y-auto">

        <p className="text-slate-500 text-xs uppercase tracking-wider mb-4">
          Navigation
        </p>

        <div className="space-y-3">

          <Link
            to="/"
            className="
              block
              px-4
              py-3
              rounded-xl
              bg-slate-800
              hover:bg-indigo-600
              hover:translate-x-1
              transition
              duration-300
            "
          >
            📊 Dashboard
          </Link>

          <Link
            to="/flights"
            className="
              block
              px-4
              py-3
              rounded-xl
              bg-slate-800
              hover:bg-indigo-600
              hover:translate-x-1
              transition
              duration-300
            "
          >
            ✈️ Flights
          </Link>

          <Link
            to="/passengers"
            className="
              block
              px-4
              py-3
              rounded-xl
              bg-slate-800
              hover:bg-indigo-600
              hover:translate-x-1
              transition
              duration-300
            "
          >
            👤 Passengers
          </Link>

          <Link
            to="/analytics"
            className="
              block
              px-4
              py-3
              rounded-xl
              bg-slate-800
              hover:bg-indigo-600
              hover:translate-x-1
              transition
              duration-300
            "
          >
            📈 Analytics
          </Link>

        </div>

      </nav>

      {/* Footer */}

      <div className="p-6 border-t border-slate-800">

        <p className="text-slate-400 text-sm">
          SkyNet v1.0
        </p>

        <p className="text-slate-500 text-xs mt-1">
          DSA Airline Management System
        </p>

      </div>

    </div>

  );
}