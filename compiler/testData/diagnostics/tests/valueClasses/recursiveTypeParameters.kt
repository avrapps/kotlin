// RUN_PIPELINE_TILL: FIR2IR
// ISSUE: KT-85848, KT-84904
// WITH_STDLIB
// LANGUAGE: +JvmInlineMultiFieldValueClasses

@JvmInline
value class TestRecursionInUpperBounds1<T : TestRecursionInUpperBounds1<T>>(val x: T, val y: T)
@JvmInline
value class TestRecursionInUpperBounds2<T : TestRecursionInUpperBounds2<T>>(val x: T?, val y: T?)
@JvmInline
value class TestRecursionInUpperBounds2_1<T : TestRecursionInUpperBounds2_1<T>>(val x: T?, val y: T)
@JvmInline
value class TestRecursionInUpperBounds2_2<T : TestRecursionInUpperBounds2_2<T>>(val x: T, val y: T?)
@JvmInline
value class TestRecursionInUpperBounds3<T : TestRecursionInUpperBounds3<T>?>(val x: T, val y: T)

/* GENERATED_FIR_TAGS: classDeclaration, nullableType, primaryConstructor, propertyDeclaration, typeConstraint,
typeParameter */
