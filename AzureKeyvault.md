# Secretos guardados en Azure Key Vault : `tecylab-key-jp`

---

## 📌 Información general
- **Uri de almacén:** [https://tecylab-key-jp.vault.azure.net/](https://tecylab-key-jp.vault.azure.net/)
- Este documento contiene una lista de secretos almacenados en Azure Key Vault para su uso en diferentes aplicaciones y servicios.

---

## 🔑 Secretos disponibles

| Nombre del secreto       | Valor                                                                 |
|--------------------------|----------------------------------------------------------------------|
| `${azure-sql-url}`       | `https://tecylab-key-jp.vault.azure.net/secrets/azure-sql-password/3aec1279f2da47b89a5cd7b171aab55e` |
| `${azure-sql-user}`      | `admin-db`                                                           |
| `${azure-sql-password}`  | `admin#123`                                                          |
| `${ccd-secret-apigw-cobis-authentication-x-api-key}`  | `k1MXI2JO3r6HRNQJFGBQKaZjymAFvReU3LW7ZqjT`                                                          |


## Crear un Service Principal para mi acceso a Azure Key Vault

Sigue estos pasos para crear un Service Principal y otorgarle acceso a Azure Key Vault:

- Abre Azure CLI o Azure Cloud Shell.
- Ejecuta el siguiente comando para crear un Service Principal:

```bash
az ad sp create-for-rbac --name "myServicePrincipal" --role "Key Vault Secrets User" --scopes /subscriptions/{subscription-id}/resourceGroups/{resource-group}/providers/Microsoft.KeyVault/vaults/{key-vault-name}
```
- Reemplaza `{subscription-id}`, `{resource-group}` y `{key-vault-name}` con los valores correspondientes a tu entorno.
- El comando devolverá un JSON con la información del Service Principal, incluyendo `appId`, `password` y `tenant`.

```bash
C:\Users\jpalo>az ad sp create-for-rbac --name "cli-azure-sp" --role "Key Vault Secrets User" --scopes /subscriptions/da1688b9-b43c-4f19-a208-cca0c9428ff3/resourceGroups/TecyLabGroup/providers/Microsoft.KeyVault/vaults/tecylab-key-jp
Creating 'Key Vault Secrets User' role assignment under scope '/subscriptions/da1688b9-b43c-4f19-a208-cca0c9428ff3/resourceGroups/TecyLabGroup/providers/Microsoft.KeyVault/vaults/tecylab-key-jp'
The output includes credentials that you must protect. Be sure that you do not include these credentials in your code or check the credentials into your source control. For more information, see https://aka.ms/azadsp-cli
{
  "appId": "xxxxxxxxxxxxxxxxxxxxxxxxx",
  "displayName": "cli-azure-sp",
  "password": "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
  "tenant": "73e2ab4a-8bce-4758-a5f0-b9c0cacc98fd"
}
```

- Toma nota de estos valores, ya que los necesitarás para configurar el acceso a Azure
- Key Vault desde tu aplicación. 
- Asignar en la variables globales de tu sistema operativo las siguientes variables:
    - `AZURE_CLIENT_ID` : appId
    - `AZURE_CLIENT_SECRET` : password
    - `AZURE_TENANT_ID` : tenant


```bash
az role assignment list --assignee a6a31aab-4216-48ab-af35-392effb555e5 --all --output table

C:\Users\jpalo>az role assignment list --assignee a6a31aab-4216-48ab-af35-392effb555e5 --all --output table
Principal                             Role                    Scope
------------------------------------  ----------------------  ----------------------------------------------------------------------------------------------------------------------------------
a6a31aab-4216-48ab-af35-392effb555e5  Key Vault Secrets User  /subscriptions/da1688b9-b43c-4f19-a208-cca0c9428ff3/resourceGroups/TecyLabGroup/providers/Microsoft.KeyVault/vaults/tecylab-key-jp
```


