import type DefaultValueClass from "./value-classes-cross-module-lib_v5.mjs";
import type { MainExternalInterface } from "./value-classes-cross-module-lib_v5.mjs";
import type { echoDefaultValueClass } from "./value-classes-cross-module-lib_v5.mjs";

type EchoDefaultValueClass = typeof echoDefaultValueClass;

function checkDefaultExportShape(value: DefaultValueClass, echo: EchoDefaultValueClass): string {
    const echoed: DefaultValueClass = echo(value);
    return echoed.value;
}

function checkExternalInterfaceShape(externalValue: MainExternalInterface): boolean {
    const directValue: number = externalValue.directValue;
    const nullableValue: MainExternalInterface["nullableValue"] = externalValue.nullableValue;
    const echoedValue: number = externalValue.echo(directValue);

    return echoedValue === directValue || nullableValue === undefined;
}

export function box(): string {
    return "OK";
}
