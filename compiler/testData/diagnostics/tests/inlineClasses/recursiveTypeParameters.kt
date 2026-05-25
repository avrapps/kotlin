// ISSUE: KT-85848, KT-84904
// WITH_STDLIB

@JvmInline
value class TestRecursionInUpperBounds1<T : TestRecursionInUpperBounds1<T>>(val x: T)
@JvmInline
value class TestRecursionInUpperBounds2<T : TestRecursionInUpperBounds2<T>>(val x: T?)
@JvmInline
value class TestRecursionInUpperBounds3<T : TestRecursionInUpperBounds3<T>?>(val x: T)

/* GENERATED_FIR_TAGS: classDeclaration, nullableType, primaryConstructor, propertyDeclaration, typeConstraint,
typeParameter */
