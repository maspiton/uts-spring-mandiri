<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Persamaan Kuadrat JSP</title>
</head>
<body style="font-family: Arial; padding: 20px;">
    <a href="/view-john" style="text-decoration: none; padding: 8px 15px; background: #007bff; color: white; border-radius: 5px;">⬅ Ke Kalkulator Gaji</a>
    <hr style="margin-top: 20px;">

    <h2>Kalkulator Persamaan Kuadrat</h2>
    <p>Bentuk Umum: <b>ax² + bx + c = 0</b></p>

    <form action="/hitung-kuadrat" method="get">
        <label>Nilai a:</label>
        <input type="number" step="any" name="a" required style="width: 70px;">

        <label>Nilai b:</label>
        <input type="number" step="any" name="b" required style="width: 70px;">

        <label>Nilai c:</label>
        <input type="number" step="any" name="c" required style="width: 70px;">

        <button type="submit" style="margin-left: 10px;">Hitung Akar</button>
    </form>

    <!-- Kalau ada error (nilai a = 0) -->
    <% if (request.getAttribute("error") != null) { %>
        <p style="color: red; font-weight: bold;"><%= request.getAttribute("error") %></p>
    <% } %>

    <!-- Tampilkan hasil kalau perhitungan sukses -->
    <% if (request.getAttribute("d") != null) { %>
        <div style="border: 1px solid #ccc; padding: 15px; width: 350px; margin-top: 20px; background-color: #f9f9f9;">
            <p><strong>Persamaan:</strong> <%= request.getAttribute("a") %>x² + <%= request.getAttribute("b") %>x + <%= request.getAttribute("c") %> = 0</p>
            <p><strong>Diskriminan (D):</strong> <%= request.getAttribute("d") %></p>
            <p><strong>Jenis Akar:</strong> <%= request.getAttribute("jenisAkar") %></p>
            <p><strong>x1 =</strong> <%= request.getAttribute("x1") %></p>
            <p><strong>x2 =</strong> <%= request.getAttribute("x2") %></p>
        </div>
    <% } %>
</body>
</html>