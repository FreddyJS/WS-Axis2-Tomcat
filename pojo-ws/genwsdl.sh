FILE=CalculatorService.wsdl
if [ -f "$FILE" ]; then
    echo "$FILE already exist!. Copying the file..."
else 
    echo "$FILE does not exist! Generating..."
    ~/axis2/bin/java2wsdl.sh -cp build/classes/ -cn calculator.CalculatorService
fi

cp CalculatorService.wsdl build/classes/META-INF
