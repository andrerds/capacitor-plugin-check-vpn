import { registerPlugin } from '@capacitor/core';

import type { CheckVpnPlugin } from './definitions';

const CheckVpn = registerPlugin<CheckVpnPlugin>('CheckVpn', {
  web: () => import('./web').then(m => new m.CheckVpnWeb()),
});

export * from './definitions';
export { CheckVpn };
