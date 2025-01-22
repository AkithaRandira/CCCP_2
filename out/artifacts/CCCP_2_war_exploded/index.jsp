<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CCCP-2 POS System</title>
    <!-- Tailwind CSS -->
    <script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="bg-gray-100 text-gray-900 font-sans leading-relaxed">
<!-- Centered Main Container -->
<div class="min-h-screen flex items-center justify-center bg-gray-200">
    <div class="max-w-lg w-full bg-white shadow-xl rounded-lg p-10">
        <!-- POS System Title -->
        <div class="text-center mb-10">
            <h1 class="text-5xl font-bold text-gray-800 tracking-tight">CCCP-2 POS System</h1>
            <p class="mt-3 text-lg text-gray-500">Select an option to continue</p>
        </div>

        <!-- Menu Options -->
        <div class="grid gap-8">
            <!-- Billing System -->
            <a href="billing" class="block border border-blue-700 hover:bg-blue-100 text-black font-semibold py-5 px-10 text-xl text-center rounded-lg shadow-md transition-all duration-300">
                Billing System
            </a>
            <!-- Report Generation -->
            <a href="report" class="block border border-blue-700 hover:bg-blue-100 text-black font-semibold py-5 px-10 text-xl text-center rounded-lg shadow-md transition-all duration-300">
                Generate Report
            </a>
            <!-- Customer Management -->
            <a href="customer" class="block border border-blue-700 hover:bg-blue-100 text-black font-semibold py-5 px-10 text-xl text-center rounded-lg shadow-md transition-all duration-300">
                Customer Management
            </a>
        </div>
    </div>
</div>
</body>

</html>
