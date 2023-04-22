var arrayValues = [7, 5, 9, 6, 1, 4, 2, 3];
for (var i = 0; i < arrayValues.length - 1; i++) {
    for (var j = 0; j < arrayValues.length - i - 1; j++) {
        if (arrayValues[j] < arrayValues[j + 1]) {
            var k = arrayValues[j];
            arrayValues[j] = arrayValues[j + 1];
            arrayValues[j + 1] = k;
        }
    }
}
console.log("descending");
console.log(arrayValues);
console.log("ascending");
for (var i = 0; i < arrayValues.length - 1; i++) {
    for (var j = 0; j < arrayValues.length - i - 1; j++) {
        if (arrayValues[j] > arrayValues[j + 1]) {
            var k = arrayValues[j];
            arrayValues[j] = arrayValues[j + 1];
            arrayValues[j + 1] = k;
        }
    }
}
console.log(arrayValues);
