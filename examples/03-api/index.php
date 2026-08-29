<?php
// AS Academy PHP — نمونه ساده Router/REST برای درک چرخه Request/Response.
declare(strict_types=1);

// پاسخ‌ها JSON هستند تا مثال برای Backend وب و موبایل قابل استفاده باشد.
header('Content-Type: application/json; charset=utf-8');

// Method و Path درخواست را می‌خوانیم.
$method = $_SERVER['REQUEST_METHOD'] ?? 'GET';
$path = parse_url($_SERVER['REQUEST_URI'] ?? '/', PHP_URL_PATH);

// Endpoint سلامت سرویس.
if ($method === 'GET' && $path === '/api/v1/health') {
    http_response_code(200);
    echo json_encode(['status' => 'ok'], JSON_UNESCAPED_UNICODE);
    exit;
}

// برای مسیر ناشناخته قرارداد خطای یکنواخت برمی‌گردانیم.
http_response_code(404);
echo json_encode([
    'error' => [
        'code' => 'NOT_FOUND',
        'message' => 'Endpoint پیدا نشد.',
    ],
], JSON_UNESCAPED_UNICODE);
