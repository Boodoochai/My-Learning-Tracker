class BST<T>
{
    BSTNode<T> Root; // корень дерева, или null

    public BST(BSTNode<T> node)
    {
        Root = node;
    }

    public BSTFind<T> FindNodeByKey(int key)
    {
        // ищем в дереве узел и сопутствующую информацию по ключу
        return null;
    }

    public boolean AddKeyValue(int key, T val)
    {
        // добавляем ключ-значение в дерево
        return false; // если ключ уже есть
    }

    public BSTNode<T> FinMinMax(BSTNode<T> FromNode, boolean FindMax)
    {
        // ищем максимальный/минимальный ключ в поддереве
        return null;
    }

    public boolean DeleteNodeByKey(int key)
    {
        // удаляем узел по ключу
        return false; // если узел не найден
    }

    public int Count()
    {
        return 0; // количество узлов в дереве
    }

}