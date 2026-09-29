<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>John Travolta JSP</title>
</head>
<body style="font-family: Arial; padding: 20px;">

    <!-- Tombol navigasi ke Persamaan Kuadrat -->
    <a href="/view-kuadrat" style="text-decoration: none; padding: 8px 15px; background: #28a745; color: white; border-radius: 5px;">➡ Ke Persamaan Kuadrat</a>
    <hr style="margin-top: 20px; margin-bottom: 20px;">

    <h2>Kalkulator Gaji John Travolta (Versi JSP)</h2>

    <form action="/hitung-jsp" method="get">
        <label>Jam Kerja per Minggu:</label>
        <input type="number" name="jamKerja" value="52" required>
        <button type="submit">Hitung</button>
    </form>

    <!-- Bagian ini akan muncul kalau atribut 'totalGaji' sudah dikirim dari Controller -->
    <% if (request.getAttribute("totalGaji") != null) { %>
        <div style="border: 1px solid #ccc; padding: 15px; width: 300px; margin-top: 20px;">
            <p><strong>Jam Kerja:</strong> <%= request.getAttribute("jamKerja") %> jam</p>
            <p><strong>Total Gaji:</strong> Rp <%= request.getAttribute("totalGaji") %></p>
            <p><strong>Pengeluaran:</strong> Rp <%= request.getAttribute("pengeluaran") %></p>
            <p><strong>Status:</strong> <%= request.getAttribute("status") %></p>
            <p><strong>Sisa Tabungan:</strong> Rp <%= request.getAttribute("tabungan") %></p>
        </div>
    <% } %>
</body>
</html>