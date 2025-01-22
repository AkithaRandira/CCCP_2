<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Billing Page</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 text-gray-900 font-sans leading-relaxed">
<div class="min-h-screen flex items-center justify-center bg-gray-200">
    <div class="max-w-4xl w-full bg-white shadow-lg rounded-lg p-6">
        <h1 class="text-2xl font-bold text-center mb-4">Welcome to the Billing Page</h1>
        <p class="text-center text-gray-700 mb-6">Please review the following information:</p>

        <!-- Billing Table -->
        <table class="table-auto w-full text-left border-collapse">
            <thead class="bg-gray-800 text-white">
            <tr>
                <th class="px-4 py-2">Item</th>
                <th class="px-4 py-2">Quantity</th>
                <th class="px-4 py-2">Price</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td class="border px-4 py-2">Sample Item 1</td>
                <td class="border px-4 py-2">2</td>
                <td class="border px-4 py-2">$20.00</td>
            </tr>
            <tr>
                <td class="border px-4 py-2">Sample Item 2</td>
                <td class="border px-4 py-2">1</td>
                <td class="border px-4 py-2">$15.00</td>
            </tr>
            <tr class="bg-gray-100">
                <td colspan="2" class="border px-4 py-2 text-right font-bold">Total</td>
                <td class="border px-4 py-2">$35.00</td>
            </tr>
            </tbody>
        </table>

        <!-- Add Item Button -->
        <div class="mt-6 text-center">
            <button class="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-700" onclick="showAddItemModal()">Add Item</button>
        </div>
    </div>
</div>

<!-- Example Modal -->
<div id="addItemModal" class="hidden fixed z-10 inset-0 overflow-y-auto">
    <div class="flex items-center justify-center min-h-screen">
        <div class="bg-white rounded-lg shadow-lg p-6 w-full max-w-md">
            <h2 class="text-xl font-bold mb-4">Add New Item</h2>
            <form id="addItemForm">
                <div class="mb-4">
                    <label for="itemName" class="block font-medium text-gray-700">Item Name</label>
                    <input type="text" id="itemName" class="w-full px-3 py-2 border rounded">
                </div>
                <div class="mb-4">
                    <label for="itemQuantity" class="block font-medium text-gray-700">Quantity</label>
                    <input type="number" id="itemQuantity" class="w-full px-3 py-2 border rounded">
                </div>
                <div class="mb-4">
                    <label for="itemPrice" class="block font-medium text-gray-700">Price</label>
                    <input type="text" id="itemPrice" class="w-full px-3 py-2 border rounded">
                </div>
                <div class="flex justify-end">
                    <button type="button" class="bg-gray-500 text-white px-4 py-2 rounded mr-2" onclick="hideAddItemModal()">Cancel</button>
                    <button type="submit" class="bg-blue-500 text-white px-4 py-2 rounded">Save</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- JavaScript for Modal -->
<script>
    function showAddItemModal() {
        document.getElementById('addItemModal').classList.remove('hidden');
    }
    function hideAddItemModal() {
        document.getElementById('addItemModal').classList.add('hidden');
    }
</script>
</body>
</html>
