<?php
// AS Academy PHP — مثال مبانی: متغیر، تابع و خروجی.
declare(strict_types=1);

// این تابع قیمت واحد را در تعداد ضرب می‌کند و جمع را برمی‌گرداند.
function calculateTotal(float $unitPrice, int $quantity): float
{
    return $unitPrice * $quantity;
}

// داده نمونه برای تمرین دانشجو.
$productName = 'PHP Course';
$unitPrice = 250000.0;
$quantity = 2;

// محاسبه و چاپ نتیجه.
$total = calculateTotal($unitPrice, $quantity);
echo $productName . ': ' . number_format($total) . PHP_EOL;
