# Tenant Management System

An Android app for landlords to record tenants, see total rent, and call tenants. Built with Kotlin, Room Database, and MVVM architecture.

## Features
- Register and log in
- Dashboard showing tenant count and total rent
- Add tenants and view all tenants (persisted with Room Database)
- Call a tenant using an Implicit Intent
- Options menu and navigation drawer

## Architecture
- `ui/`: Activities, Fragments, and TenantViewModel (UI layer)
- `data/`: Tenant, TenantDao, TenantDatabase, TenantRepository (Data layer)

## Team & Contributions
| Stage | Member | Admission No. | Pull Request |
|---|---|---|---|
| 1 Lead | Mark Gitau | 166438 | https://github.com/mrggitau/tenant-management-system/pull/5 |
| 2 ViewModel | Ramilla Kitar | 189654 | https://github.com/mrggitau/tenant-management-system/pull/1 |
| 3 Room | Sean Kwendo | 190060 | https://github.com/mrggitau/tenant-management-system/pull/3 |
| 4 Screens | Natasha Mumbi | 189602 | https://github.com/mrggitau/tenant-management-system/pull/2 |
| 5 Data Integration | Suhaymah Abdulatif | 190168 | https://github.com/mrggitau/tenant-management-system/pull/4 |
| 6 Release | Mark Gitau | 166438 | https://github.com/mrggitau/tenant-management-system/pull/5 |

Our 6th member, Benson Mwangi - 189815, helped the lead with the release and minor debugging and resolving conflicts.