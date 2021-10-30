<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP - Compound Interest Calculator</title>
        <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
    </head>
    <body class="bg-blue-500">
        <p>${error}</p>

        <div>
            <div class="bg-white mx-auto text-center w-1/2 py-5 shadow-xl rounded-3xl my-96 max-w-2xl">
                <form action="/" method="post">
                    <h2 class="text-4xl font-semibold border-b pd-2 mx-6">Compound Interest Calculator</h2>
                    <h3 class="bg-red-300 text-red-900 font-semibold text-xl w-80 rounded-lg mx-auto">${error}</h3>
                    <div class="grid grid-cols-2 gap-4 my-5 mx-8">
                        <label for="principal-amount" class="text-xl flex items-center">Principal Amount:<span class="text-gray-500 mx-1">$</span></label>
                        <input
                                class="w-full p-1 border-2 placeholder-blue-800 border-blue-700 appearance-none rounded-lg focus:outline-none focus:ring-2"
                                id="principal-amount"
                                type="number"
                                name="principal-amount"
                                value="${principal}"
                        >

                        <label for="interest-percentage" class="text-xl flex items-center">Interest Percentage:</label>
                        <input
                                class="w-full p-1 border-2 placeholder-blue-800 border-blue-700 appearance-none rounded-lg focus:outline-none focus:ring-2"
                                id="interest-percentage"
                                type="number"
                                min="1"
                                max="100"
                                name="interest-percentage"
                                value="${interest}"
                        >

                        <label for="years" class="text-xl flex items-center"># of Years:</label>
                        <input
                                class="w-full p-1 border-2 placeholder-blue-800 border-blue-700 appearance-none rounded-lg focus:outline-none focus:ring-2"
                                id="years"
                                type="number"
                                min="1"
                                name="years"
                                value="${years}"
                        >

                        <label for="compounding-period" class="text-xl flex items-center">Times per Year:</label>
                        <input
                                class="w-full p-1 border-2 placeholder-blue-800 border-blue-700 appearance-none rounded-lg focus:outline-none focus:ring-2"
                                id="compounding-period"
                                type="number"
                                min="1"
                                max="12"
                                name="compounding-period"
                                value="${compounding}"
                        >
                    </div>
                    <button type="submit" class="bg-blue-300 text-xl font-semibold px-4 py-1 rounded-lg hover:bg-blue-800 hover:text-white">Calculate</button>
                    <p class="text-3xl font-mono text-green-600">Result: ${result}</p>
                </form>
            </div>

        </div>
    </body>
</html>